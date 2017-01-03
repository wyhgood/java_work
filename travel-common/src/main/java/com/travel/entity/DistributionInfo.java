package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class DistributionInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7051291969667313518L;
	
	private Integer distNum;
	@Lob
	private String distDetail;
	
	public Integer getDistNum() {
		return distNum;
	}
	public void setDistNum(Integer distNum) {
		this.distNum = distNum;
	}
	public String getDistDetail() {
		return distDetail;
	}
	public void setDistDetail(String distDetail) {
		this.distDetail = distDetail;
	}
}
