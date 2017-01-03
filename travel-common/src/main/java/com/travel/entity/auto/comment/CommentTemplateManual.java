package com.travel.entity.auto.comment;

import java.io.Serializable;

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
public class CommentTemplateManual implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5568138990614626529L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Index(name="comment_template_id")
	private Integer commentTemplateId;
	@Index(name="user_comment_id")
	private Long userCommentId;
	private String wildComment;
	private String nounTag;
	private Integer sentenceIdx;
	private String placeType;
	private Double score;
	private Integer rawId;
	//菜系类别、景点类别、购物类别
	private String poiType;
	//0:brand 1:pos -1:neg
	private int polarity;
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
	public void copyTo(CommentTemplate commentTemplate){
		commentTemplate.setNounTag(nounTag);
		commentTemplate.setPlaceType(placeType);
		commentTemplate.setPoiType(poiType);
		commentTemplate.setScore(score);
		commentTemplate.setSentenceIdx(sentenceIdx);
		commentTemplate.setUserCommentId(userCommentId);
		commentTemplate.setWildComment(wildComment);
		commentTemplate.setPolarity(polarity);
		commentTemplate.setRawId(rawId);
	}
	public int getPolarity() {
		return polarity;
	}
	public void setPolarity(int polarity) {
		this.polarity = polarity;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
}
