package com.travel.entity.auto.comment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"templateKey","template"},name="uniqueidx"))
public class TransactionConjunction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2087605371482293520L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String template;
	private Double prob;
	private String templateKey;
	private Date ts;
	/**
	 * canyin
	 * jiudian
	 * jingdian
	 * gouwu
	 * common
	 */
	private String placeType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public Double getProb() {
		return prob;
	}
	public void setProb(Double prob) {
		this.prob = prob;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public String getTemplateKey() {
		return templateKey;
	}
	public void setTemplateKey(String templateKey) {
		this.templateKey = templateKey;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
}
