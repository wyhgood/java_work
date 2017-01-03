package com.travel.entity.score.detail;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MergeReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3581481791681882333L;
	//总的正确率
	static final public int REPORT_TYPE_CORRECT_NUM_SUM=1;
	//总的错误率
	static final public int REPORT_TYPE_WRONG_NUM_SUM=2;
	//错误数据的修正率
	static final public int REPORT_TYPE_FIX_WRONG_NUM=3;
	//正确数据的错误率
	static final public int REPORT_TYPE_WRONG_FIX_NUM=4;
	//错误数据半修正(由错误状态进入到人工状态)
	static final public int REPORT_TYPE_FIX_WRONG_HALF=5;
	//
	static final public int REPORT_TYPE_ABS_WRONG_FIX_NUM=6;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer reportType;
	private double rate;
	private int count;
	private Integer reportId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReportType() {
		return reportType;
	}
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
