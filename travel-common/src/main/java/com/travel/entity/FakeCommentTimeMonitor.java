package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class FakeCommentTimeMonitor implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mergeId;
	
	private Date updateTime;
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3908968218783257752L;





	public Long getMergeId() {
		return mergeId;
	}





	public void setMergeId(Long mergeId) {
		this.mergeId = mergeId;
	}





	public Date getUpdateTime() {
		return updateTime;
	}





	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
}