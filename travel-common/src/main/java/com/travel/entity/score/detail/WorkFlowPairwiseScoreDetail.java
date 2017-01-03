package com.travel.entity.score.detail;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkFlowPairwiseScoreDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8296304204200541966L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Embedded
	private PairwiseScoreDetailBase scoreDetail;
	
	public PairwiseScoreDetailBase getScoreDetail() {
		return scoreDetail;
	}

	public void setScoreDetail(PairwiseScoreDetailBase scoreDetail) {
		this.scoreDetail = scoreDetail;
	}
	public void init(){
		scoreDetail = new PairwiseScoreDetailBase();
	}
}
