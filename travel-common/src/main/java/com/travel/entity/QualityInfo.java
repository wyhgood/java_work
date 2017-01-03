package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class QualityInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1646748162446003408L;
	@Column(columnDefinition="double default '0.0'")
	private Double infoScore;
	@Column(columnDefinition="double default '0.0'")
	private Double originInfoScore;
	@Column(columnDefinition="double default '0.0'")
	private Double commentScore;
	@Column(columnDefinition="double default '0.0'")
	private Double starScore;
	@Column(columnDefinition="double default '0.0' not null")
	private Double rateCount;
	public Double getRateCount() {
		return rateCount;
	}
	public void setRateCount(Double rateCount) {
		this.rateCount = rateCount;
	}
	public Double getInfoScore() {
		return infoScore;
	}
	public void setInfoScore(Double infoScore) {
		this.infoScore = infoScore;
	}
	public Double getCommentScore() {
		return commentScore;
	}
	public void setCommentScore(Double commentScore) {
		this.commentScore = commentScore;
	}
	public Double getStarScore() {
		return starScore;
	}
	public void setStarScore(Double starScore) {
		this.starScore = starScore;
	}
	public Double getOriginInfoScore() {
		return originInfoScore;
	}
	public void setOriginInfoScore(Double originInfoScore) {
		this.originInfoScore = originInfoScore;
	}
}
