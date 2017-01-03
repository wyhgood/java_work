package com.travel.entity.auto.comment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "rawId",
		"tag", "polarity" }, name = "uniqueIdx"))
@Entity
public class PoiTagDist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321164908978427589L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer rawId;
	private String tag;
	private Integer polarity;
	private Integer count;
	private Double rate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getPolarity() {
		return polarity;
	}
	public void setPolarity(Integer polarity) {
		this.polarity = polarity;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public void copyFrom(PoiTagDist poiTagDist){
		this.rate = poiTagDist.getRate();
		this.count = poiTagDist.getCount();
	}
}
