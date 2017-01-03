package com.travel.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

@Entity
public class CompareIdEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6174154686671893339L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int status;
	private int processCount = 0;
	private int totalCount = 0;
	private int splitCount = 0;
	private int mergeCount = 0;
	private int splitErrorCount = 0;
	private int mergeErrorCount = 0;
	private String version;
	private Date startTime = new Date();
	private Date endTime;
	@Transient
	private String formatStartTime;
	@Transient
	private String formatEndTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.formatStartTime = sdf.format(startTime);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getProcessCount() {
		return processCount;
	}

	public void setProcessCount(int processCount) {
		this.processCount = processCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.formatEndTime = sdf.format(endTime);
	}

	public synchronized void incrProcessCount(int count) {
		this.processCount += count;
	}

	public String getFormatEndTime() {
		return formatEndTime;
	}

	public void setFormatEndTime(String formatEndTime) {
		this.formatEndTime = formatEndTime;
	}

	public String getFormatStartTime() {
		return formatStartTime;
	}

	public void setFormatStartTime(String formatStartTime) {
		this.formatStartTime = formatStartTime;
	}

	public int getSplitCount() {
		return splitCount;
	}

	public void setSplitCount(int splitCount) {
		this.splitCount = splitCount;
	}

	public int getMergeCount() {
		return mergeCount;
	}

	public void setMergeCount(int mergeCount) {
		this.mergeCount = mergeCount;
	}

	public int getSplitErrorCount() {
		return splitErrorCount;
	}

	public void setSplitErrorCount(int splitErrorCount) {
		this.splitErrorCount = splitErrorCount;
	}

	public int getMergeErrorCount() {
		return mergeErrorCount;
	}

	public void setMergeErrorCount(int mergeErrorCount) {
		this.mergeErrorCount = mergeErrorCount;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
