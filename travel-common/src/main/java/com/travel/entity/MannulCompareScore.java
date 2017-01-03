package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MannulCompareScore implements Serializable {

	private static final long serialVersionUID = -5844094387913773202L;

	@Id
	@Embedded
	private MannulCompareScoreId id;
	private double score;

	@Column(insertable = true, updatable = false)
	private Date createTime = new Date();
	private Date updateTime = new Date();

	private String username;

	public MannulCompareScoreId getId() {
		return id;
	}

	public void setId(MannulCompareScoreId id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
