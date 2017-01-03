package com.travel.entity.auto.desc;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Index;
@Entity
public class RawDataAutoDesc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1875023087726440226L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	@Index(name="merge_id")
	private Integer mergeId;
	@Column(columnDefinition="varchar(100)",length=100)
	private String autoDesc;
	private Date ts;
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMergeId() {
		return mergeId;
	}
	public void setMergeId(Integer mergeId) {
		this.mergeId = mergeId;
	}
	public String getAutoDesc() {
		return autoDesc;
	}
	public void setAutoDesc(String autoDesc) {
		this.autoDesc = autoDesc;
	}
}
