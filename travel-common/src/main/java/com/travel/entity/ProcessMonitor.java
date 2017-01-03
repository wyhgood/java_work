package com.travel.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ProcessMonitor implements Serializable {
	private static final long serialVersionUID = 4388348665169631061L;

	public static final int STATUS_RUN = 0;
	public static final int STATUS_END = 1;
	public static final int STATUS_FAILED = 2;
	public static final int STATUS_KILLED = 3;
	public static final int STATUS_EXCEPTION_END = 4;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String addr;
	private String processId;
	private String threadId;
	private Long iTime;
	private Long diffTime;
	private long delayTime = 1000*60;
	private long maxTryNum = 1;
	private Integer status = 0;
	private Date createTime;
	private Date endTime;
	private int sendEmail;

	@Transient
	private long time = System.currentTimeMillis();
	@Transient
	public int tryNum = 0;

	public ProcessMonitor() {
	}

	public ProcessMonitor(String addr, String key, String threadId, long interval, long t) {
		this.addr = addr;
		this.processId = key;
		this.threadId = threadId;
		this.iTime = interval;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(t);
		createTime = calendar.getTime();
		this.diffTime = System.currentTimeMillis() - t;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInterval(long interval) {
		this.iTime = interval;
	}

	public long getInterval() {
		return iTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public long getDiffTime() {
		return diffTime;
	}

	public void setDiffTime(long diffTime) {
		this.diffTime = diffTime;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public long getMaxTryNum() {
		return maxTryNum;
	}

	public void setMaxTryNum(long maxTryNum) {
		this.maxTryNum = maxTryNum;
	}

	public long getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}

	public int getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(int sendEmail) {
		this.sendEmail = sendEmail;
	}

	public String getKey() {
		String key = addr + "-" + processId;
		if (threadId != null) {
			key = key + "-" + threadId;
		}
		return key;
	}
}
