package com.travel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;

@Embeddable
public class PopularInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 867089420492505647L;
	private Double PopularInfo_strProductScore;
	private Double PopularInfo_strEnviromentScore;
	private Double PopularInfo_strServiceScore;
	private Double PopularInfo_strScore;
	// @Index(name = "rate_count_index")
	private Double PopularInfo_strRateCount;
	private Double PopularInfo_strPoRateCount;
	@Lob
	private String PopularInfo_listUserComment;
	private Integer PopularInfo_userCommentSize;
	@Transient
	private List<String> listUserComment;
	@Lob
	private String PopularInfo_listTags;
	@Transient
	private List<String> listTags;

	public List<String> getListTags() {
		return listTags;
	}

	public void setListTags(List<String> listTags) {
		this.listTags = listTags;
	}

	public Double getPopularInfo_strProductScore() {
		return PopularInfo_strProductScore;
	}

	public void setPopularInfo_strProductScore(Double popularInfo_strProductScore) {
		PopularInfo_strProductScore = popularInfo_strProductScore;
	}

	public Double getPopularInfo_strEnviromentScore() {
		return PopularInfo_strEnviromentScore;
	}

	public void setPopularInfo_strEnviromentScore(Double popularInfo_strEnviromentScore) {
		PopularInfo_strEnviromentScore = popularInfo_strEnviromentScore;
	}

	public Double getPopularInfo_strServiceScore() {
		return PopularInfo_strServiceScore;
	}

	public void setPopularInfo_strServiceScore(Double popularInfo_strServiceScore) {
		PopularInfo_strServiceScore = popularInfo_strServiceScore;
	}

	public Double getPopularInfo_strScore() {
		return PopularInfo_strScore;
	}

	public void setPopularInfo_strScore(Double popularInfo_strScore) {
		PopularInfo_strScore = popularInfo_strScore;
	}

	public Double getPopularInfo_strRateCount() {
		return PopularInfo_strRateCount;
	}

	public void setPopularInfo_strRateCount(Double popularInfo_strRateCount) {
		PopularInfo_strRateCount = popularInfo_strRateCount;
	}

	public String getPopularInfo_listUserComment() {
		return PopularInfo_listUserComment;
	}

	public void setPopularInfo_listUserComment(String popularInfo_listUserComment) {
		PopularInfo_listUserComment = popularInfo_listUserComment;
	}

	public String getPopularInfo_listTags() {
		return PopularInfo_listTags;
	}

	public void setPopularInfo_listTags(String popularInfo_listTags) {
		PopularInfo_listTags = popularInfo_listTags;
	}

	public Integer getPopularInfo_userCommentSize() {
		return PopularInfo_userCommentSize;
	}

	public void setPopularInfo_userCommentSize(Integer popularInfo_userCommentSize) {
		PopularInfo_userCommentSize = popularInfo_userCommentSize;
	}

	public Double getPopularInfo_strPoRateCount() {
		return PopularInfo_strPoRateCount;
	}

	public void setPopularInfo_strPoRateCount(Double popularInfo_strPoRateCount) {
		this.PopularInfo_strPoRateCount = popularInfo_strPoRateCount;
	}

	public boolean checkAndSetPoRateCount(Double popularInfo_strPoRateCount) {
		if (this.PopularInfo_strPoRateCount == null) {
			if (popularInfo_strPoRateCount == null) {
				return false;
			}
			this.PopularInfo_strPoRateCount = popularInfo_strPoRateCount;
			return true;
		} else {
			if (popularInfo_strPoRateCount == null || this.PopularInfo_strPoRateCount.compareTo(popularInfo_strPoRateCount) == 0) {
				return false;
			}
			this.PopularInfo_strPoRateCount = popularInfo_strPoRateCount;
			return true;
		}
	}
}
