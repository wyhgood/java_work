package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="merge_out_monitor")
public class MergeOutMonitor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -83035710521874464L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private String city;
	private String field;
	private Integer nullNum;
	private Integer notNullNum;
	private Float nullPropotion;
	private Float notNullPropotion;
	private Integer formalized;
	private Integer notFormalized;
	private Float formPropotion;
	private Float notFormalizedPropotion;
	private Integer corrected;
	private Integer notCorrected;
	private Float correctedPropotion;
	private Float notCorrectedPropotion;
	private Integer reportId;
	private String updateTs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Integer getNullNum() {
		return nullNum;
	}
	public void setNullNum(Integer nullNum) {
		this.nullNum = nullNum;
	}
	public Integer getNotNullNum() {
		return notNullNum;
	}
	public void setNotNullNum(Integer notNullNum) {
		this.notNullNum = notNullNum;
	}
	public Float getNullPropotion() {
		return nullPropotion;
	}
	public void setNullPropotion(Float nullPropotion) {
		this.nullPropotion = nullPropotion;
	}
	public Float getNotNullPropotion() {
		return notNullPropotion;
	}
	public void setNotNullPropotion(Float notNullPropotion) {
		this.notNullPropotion = notNullPropotion;
	}
	public Integer getFormalized() {
		return formalized;
	}
	public void setFormalized(Integer formalized) {
		this.formalized = formalized;
	}
	public Integer getNotFormalized() {
		return notFormalized;
	}
	public void setNotFormalized(Integer notFormalized) {
		this.notFormalized = notFormalized;
	}
	public Float getFormPropotion() {
		return formPropotion;
	}
	public void setFormPropotion(Float formPropotion) {
		this.formPropotion = formPropotion;
	}
	public Float getNotFormalizedPropotion() {
		return notFormalizedPropotion;
	}
	public void setNotFormalizedPropotion(Float notFormalizedPropotion) {
		this.notFormalizedPropotion = notFormalizedPropotion;
	}
	public Integer getCorrected() {
		return corrected;
	}
	public void setCorrected(Integer corrected) {
		this.corrected = corrected;
	}
	public Integer getNotCorrected() {
		return notCorrected;
	}
	public void setNotCorrected(Integer notCorrected) {
		this.notCorrected = notCorrected;
	}
	public Float getCorrectedPropotion() {
		return correctedPropotion;
	}
	public void setCorrectedPropotion(Float correctedPropotion) {
		this.correctedPropotion = correctedPropotion;
	}
	public Float getNotCorrectedPropotion() {
		return notCorrectedPropotion;
	}
	public void setNotCorrectedPropotion(Float notCorrectedPropotion) {
		this.notCorrectedPropotion = notCorrectedPropotion;
	}
	public String getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(String dt) {
		this.updateTs = dt;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
}