package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DaodaoHotelRedirectMapping implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5355245536795129497L;
	static public String TYPE_AGODA = "agoda";
	static public String TYPE_BOOKING = "BookingCom";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long rawId;
	private String daodaoId;
	private String type = "";
	private String toDaodaoId;
	private String toUrl;
	@Column(insertable = true, updatable = false)
	private Date createTime = new Date();
	private Date updateTime;
	private int httpStatus = 200;
	private int redirectStatus = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRawId() {
		return rawId;
	}

	public void setRawId(long rawId) {
		this.rawId = rawId;
	}

	public String getDaodaoId() {
		return daodaoId;
	}

	public void setDaodaoId(String daodaoId) {
		this.daodaoId = daodaoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToDaodaoId() {
		return toDaodaoId;
	}

	public void setToDaodaoId(String toDaodaoId) {
		this.toDaodaoId = toDaodaoId;
	}

	public String getToUrl() {
		return toUrl;
	}

	public void setToUrl(String toUrl) {
		if (toUrl != null) {
			this.toUrl = toUrl;
		}
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setHttpStatus(int statusCode) {
		this.httpStatus = statusCode;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setRedirectStatus(int redirectStatusCode) {
		this.redirectStatus = redirectStatusCode;
	}

	public int getRedirectStatus() {
		return redirectStatus;
	}
}
