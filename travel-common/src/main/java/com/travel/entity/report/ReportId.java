package com.travel.entity.report;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReportId implements Serializable{

	final static public int REPORT_TYPE_PLACEINFONEW = 1;
	final static public int REPORT_TYPE_MERGEOUT = 2;
	final static public int REPORT_TYPE_RAWDATA = 3;
	
	final static public int STATUS_FAILED = -1;
	final static public int STATUS_START = 0;
	final static public int STATUS_SUCCESS = 1;
	final static public int STATUS_PROCESSING = 2;
	final static public int STATUS_STATISTICS = 3;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6262212490813764018L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date ts;
	private String comment;
	private Integer reportType;
	private Integer status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getReportType() {
		return reportType;
	}
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
