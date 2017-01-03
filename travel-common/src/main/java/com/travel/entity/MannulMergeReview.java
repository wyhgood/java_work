package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MannulMergeReview implements Serializable {
	private static final long serialVersionUID = 2796200005851280997L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long mergeId;
	private long rawId;
	private int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMergeId() {
		return mergeId;
	}

	public void setMergeId(long mergeId) {
		this.mergeId = mergeId;
	}

	public long getRawId() {
		return rawId;
	}

	public void setRawId(long rawId) {
		this.rawId = rawId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
