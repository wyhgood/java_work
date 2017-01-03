package com.travel.entity.auto.desc;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Index;

@Embeddable
public class AutoDescModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2714649638014625431L;
	@Index(name="merge_id")
	private Integer mergeId;
	@Column(columnDefinition="varchar(1000)",length=1000)
	private String autoDesc;
	private Date ts;
	private Double originScore;
	private Double entropy;
	/**
	 * 如果status=10则不允许进行修改
	 */
	private Integer status;
	
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
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
	public Double getOriginScore() {
		return originScore;
	}
	public void setOriginScore(Double originScore) {
		this.originScore = originScore;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getEntropy() {
		return entropy;
	}
	public void setEntropy(Double entropy) {
		this.entropy = entropy;
	}
}
