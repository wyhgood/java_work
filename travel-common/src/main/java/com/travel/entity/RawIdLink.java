package com.travel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RawIdLink {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long rawId;

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
}
