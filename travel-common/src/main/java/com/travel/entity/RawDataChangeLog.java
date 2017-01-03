package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class RawDataChangeLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2415400220272492810L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rawId;
	private String username;
	@Lob
	private String oldJson;
	@Lob
	private String newJson;
	private Date createTime = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldJson() {
		return oldJson;
	}

	public void setOldJson(String oldJson) {
		this.oldJson = oldJson;
	}

	public String getNewJson() {
		return newJson;
	}

	public void setNewJson(String newJson) {
		this.newJson = newJson;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getRawId() {
		return rawId;
	}

	public void setRawId(int rawId) {
		this.rawId = rawId;
	}
}
