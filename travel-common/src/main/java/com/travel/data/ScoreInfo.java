package com.travel.data;

import java.io.Serializable;

public class ScoreInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1707686111785898455L;
	private double score;
	private double distance;
	private double matchrate;
	private double phonematchrae;
	private double rateCount;
	private String debugInfo;
	// 那个rawId拉出来的数据
	private Integer rawId;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getMatchrate() {
		return matchrate;
	}
	public void setMatchrate(double matchrate) {
		this.matchrate = matchrate;
	}
	public double getPhonematchrae() {
		return phonematchrae;
	}
	public void setPhonematchrae(double phonematchrae) {
		this.phonematchrae = phonematchrae;
	}
	public String getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	public double getRateCount() {
		return rateCount;
	}
	public void setRateCount(double rateCount) {
		this.rateCount = rateCount;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	
}
