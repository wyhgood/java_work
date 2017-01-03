package com.travel.entity.workflow;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.travel.entity.RawIdMergeEmbeddedId;

@Entity
public class RawIdMergeIdMappingChange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5117726104886520167L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Embedded
	RawIdMergeEmbeddedId embeddedId;
	private Long mappingId;
	private String toMergeId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RawIdMergeEmbeddedId getEmbeddedId() {
		return embeddedId;
	}
	public void setEmbeddedId(RawIdMergeEmbeddedId embeddedId) {
		this.embeddedId = embeddedId;
	}
	public Long getMappingId() {
		return mappingId;
	}
	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}
	public String getToMergeId() {
		return toMergeId;
	}
	public void setToMergeId(String toMergeId) {
		this.toMergeId = toMergeId;
	}
}
