package com.travel.entity.auto.comment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Index;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCommentId",
		"sentenceIdx", "nounTag" }, name = "uniqueIdx"))
@Entity
public class CommentTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4368902873055846201L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Index(name="user_comment_id")
	private Long userCommentId;
	private String wildComment;
	private String originComment;
	private String nounTag;
	private Integer sentenceIdx;
	private String placeType;
	private Double score;
	private Integer rawId;
	//菜系类别、景点类别、购物类别
	private String poiType;
	//0:brand 1:pos -1:neg
	private Integer polarity;
	//1:表示被人工编辑过
	@Index(name="status_idx")
	private Integer status=0;
	private Date ts;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserCommentId() {
		return userCommentId;
	}
	public void setUserCommentId(Long userCommentId) {
		this.userCommentId = userCommentId;
	}
	public String getWildComment() {
		return wildComment;
	}
	public void setWildComment(String wildComment) {
		this.wildComment = wildComment;
	}
	public String getNounTag() {
		return nounTag;
	}
	public void setNounTag(String nounTag) {
		this.nounTag = nounTag;
	}
	public Integer getSentenceIdx() {
		return sentenceIdx;
	}
	public void setSentenceIdx(Integer sentenceIdx) {
		this.sentenceIdx = sentenceIdx;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getPoiType() {
		return poiType;
	}
	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}
	public void copyTo(CommentTemplate dbData){
		dbData.setPlaceType(placeType);
		dbData.setPoiType(poiType);
		if(dbData.getStatus()==null || dbData.getStatus()!=1){
			dbData.setNounTag(nounTag);
			dbData.setScore(score);
			dbData.setSentenceIdx(sentenceIdx);
			dbData.setUserCommentId(userCommentId);
			dbData.setWildComment(wildComment);
			dbData.setPolarity(polarity);
			dbData.setRawId(rawId);
			dbData.setOriginComment(originComment);
		}
	}
	public Integer getPolarity() {
		return polarity;
	}
	public void setPolarity(Integer polarity) {
		this.polarity = polarity;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOriginComment() {
		return originComment;
	}
	public void setOriginComment(String originComment) {
		this.originComment = originComment;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
}
