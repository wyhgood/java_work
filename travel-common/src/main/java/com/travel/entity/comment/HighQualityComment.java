package com.travel.entity.comment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class HighQualityComment implements Serializable {
	
	final public static int STATUS_DELETED = -1;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8735969155607204690L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition="varchar(50)",length=50)
	private String commentId;
	private Long rawId;
	private Integer mergeId;
	@Column(columnDefinition="varchar(4000)",length=4000)
	private String commentText;
	@Column(columnDefinition="varchar(100)",length=100)
	private String digest;
	private Double score;
	private Double entropy;
	private Double rankScore;
	private Integer status;
	@Column(columnDefinition="varchar(40)",length=40)
	private String commentTime;
	@Transient
	private String debugInfo;
	public String getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public Long getRawId() {
		return rawId;
	}
	public void setRawId(Long rawId) {
		this.rawId = rawId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Double getEntropy() {
		return entropy;
	}
	public void setEntropy(Double entropy) {
		this.entropy = entropy;
	}
	public Double getRankScore() {
		return rankScore;
	}
	public void setRankScore(Double rankScore) {
		this.rankScore = rankScore;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMergeId() {
		return mergeId;
	}
	public void setMergeId(Integer mergeId) {
		this.mergeId = mergeId;
	}
	
	public void copyTo(HighQualityComment comment){
		comment.setCommentId(commentId);
		comment.setCommentText(commentText);
		comment.setCommentTime(commentTime);
		comment.setDebugInfo(debugInfo);
		comment.setDigest(digest);
		comment.setEntropy(entropy);
		comment.setMergeId(mergeId);
		comment.setRankScore(rankScore);
		comment.setRawId(rawId);
		comment.setScore(rankScore);
		comment.setStatus(status);
	}
}
