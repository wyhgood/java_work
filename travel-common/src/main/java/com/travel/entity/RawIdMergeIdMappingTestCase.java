package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "rawid_mergeid_mapping_testcase")
public class RawIdMergeIdMappingTestCase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1536955753438673776L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	RawIdMergeEmbeddedId embeddedId;
	private String city;
	private Date createDate = new Date();

	public RawIdMergeEmbeddedId getEmbeddedId() {
		return embeddedId;
	}

	public void setEmbeddedId(RawIdMergeEmbeddedId embeddedId) {
		this.embeddedId = embeddedId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
