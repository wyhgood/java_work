package com.travel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopMergeId {
	@Id
	private long mergeId;
	private String city;

	public long getMergeId() {
		return mergeId;
	}

	public void setMergeId(long mergeId) {
		this.mergeId = mergeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
