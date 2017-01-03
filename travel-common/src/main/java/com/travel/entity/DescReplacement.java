package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class DescReplacement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 980840089338030760L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Long mergeId;
	@Column(columnDefinition="varchar(5000)",length=5000)
	private String description;
	private Integer flag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getMergeId() {
		return mergeId;
	}
	public void setMergeId(Long mergeId) {
		this.mergeId = mergeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
