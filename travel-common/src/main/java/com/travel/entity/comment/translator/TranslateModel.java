package com.travel.entity.comment.translator;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TranslateModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6863302563354359804L;
	private String orgSentence;
	private String distSentence;
	private String placeName;
	private Integer rawId;
	private Integer idxInComment;
	private Double score;
	private Double biGramSeScore;
	private Double threeGramSeScore;
	private Double fourGramSeScore;
	private Double lenScore;
	private Double distScore;
	private Double srcScore;
	private String se;
	private String preSentence;
	private Long ucId;
	private Integer distLen;
	@Column(columnDefinition="varchar(20)",length=20)
	private String placeType;
	@Column(columnDefinition="varchar(10000)",length=10000)
	private String debugInfo;
	private Integer isFinal;
	private Double emotionScore;
	private Date updateTs;
	
	private String tag;
	private Integer tagF;
	@Column(columnDefinition="varchar(20)",length=20)
	private String tagNoun;
	
	public String getOrgSentence() {
		return orgSentence;
	}
	public void setOrgSentence(String orgSentence) {
		this.orgSentence = orgSentence;
	}
	public String getDistSentence() {
		return distSentence;
	}
	public void setDistSentence(String distSentence) {
		this.distSentence = distSentence;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	public Integer getIdxInComment() {
		return idxInComment;
	}
	public void setIdxInComment(Integer idxInComment) {
		this.idxInComment = idxInComment;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	public Double getBiGramSeScore() {
		return biGramSeScore;
	}
	public void setBiGramSeScore(Double biGramSeScore) {
		this.biGramSeScore = biGramSeScore;
	}
	public Double getThreeGramSeScore() {
		return threeGramSeScore;
	}
	public void setThreeGramSeScore(Double threeGramSeScore) {
		this.threeGramSeScore = threeGramSeScore;
	}
	public Double getFourGramSeScore() {
		return fourGramSeScore;
	}
	public void setFourGramSeScore(Double fourGramSeScore) {
		this.fourGramSeScore = fourGramSeScore;
	}
	public Double getLenScore() {
		return lenScore;
	}
	public void setLenScore(Double lenScore) {
		this.lenScore = lenScore;
	}
	public Double getDistScore() {
		return distScore;
	}
	public void setDistScore(Double distScore) {
		this.distScore = distScore;
	}
	public Double getSrcScore() {
		return srcScore;
	}
	public void setSrcScore(Double srcScore) {
		this.srcScore = srcScore;
	}
	public String getSe() {
		return se;
	}
	public void setSe(String se) {
		this.se = se;
	}
	public String getPreSentence() {
		return preSentence;
	}
	public void setPreSentence(String preSentence) {
		this.preSentence = preSentence;
	}
	public Integer getIsFinal() {
		return isFinal;
	}
	public void setIsFinal(Integer isFinal) {
		this.isFinal = isFinal;
	}
	public Long getUcId() {
		return ucId;
	}
	public void setUcId(Long ucId) {
		this.ucId = ucId;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public Integer getDistLen() {
		return distLen;
	}
	public void setDistLen(Integer distLen) {
		this.distLen = distLen;
	}
	public Double getEmotionScore() {
		return emotionScore;
	}
	public void setEmotionScore(Double emotionScore) {
		this.emotionScore = emotionScore;
	}
	public Date getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getTagF() {
		return tagF;
	}
	public void setTagF(Integer tagF) {
		this.tagF = tagF;
	}
	public String getTagNoun() {
		return tagNoun;
	}
	public void setTagNoun(String tagNoun) {
		this.tagNoun = tagNoun;
	}
	public void copyTo(TranslateModel tc){
		tc.setBiGramSeScore(biGramSeScore);
		tc.setDebugInfo(debugInfo);
		tc.setDistLen(distLen);
		tc.setDistScore(distScore);
		tc.setDistSentence(distSentence);
		tc.setEmotionScore(emotionScore);
		tc.setFourGramSeScore(fourGramSeScore);
		tc.setIdxInComment(idxInComment);
		tc.setIsFinal(isFinal);
		tc.setLenScore(lenScore);
		tc.setOrgSentence(orgSentence);
		tc.setPlaceName(placeName);
		tc.setPlaceType(placeType);
		tc.setPreSentence(preSentence);
		tc.setRawId(rawId);
		tc.setScore(score);
		tc.setSe(se);
		tc.setSrcScore(srcScore);
		tc.setThreeGramSeScore(threeGramSeScore);
		tc.setUcId(ucId);
		tc.setUpdateTs(updateTs);
	}
}
