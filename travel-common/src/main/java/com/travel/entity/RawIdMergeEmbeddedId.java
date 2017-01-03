package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Index;

@Embeddable
public class RawIdMergeEmbeddedId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -482211633521781029L;
//	@Index(name="raw_id_index")
	private String rawId;
//	@Index(name="merge_id_index")
	private String mergeId;
	public String getRawId() {
		return rawId;
	}
	public void setRawId(String rawId) {
		this.rawId = rawId;
	}
	public String getMergeId() {
		return mergeId;
	}
	public void setMergeId(String mergeId) {
		this.mergeId = mergeId;
	}
}
