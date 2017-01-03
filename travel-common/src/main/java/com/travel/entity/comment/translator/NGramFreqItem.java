package com.travel.entity.comment.translator;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NGramFreqItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5307871878137356119L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String gramItem;
	private Integer freq;
	public String getGramItem() {
		return gramItem;
	}
	public void setGramItem(String gramItem) {
		this.gramItem = gramItem;
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
