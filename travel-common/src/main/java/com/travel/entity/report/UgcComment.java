//package com.travel.entity.report;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity(name="ugc_comment_new")
//public class UgcComment implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1348276844831550384L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private Long parentid;
//	private Long uid;
//	private Long touid;
//	private Long placeid;
//	private String content;
//	private String pics;
//	private Integer type;
//	private Integer status;
//	private Double score;
//	private String thirdwebid;
//	private java.util.Date createtime;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Long getParentid() {
//		return parentid;
//	}
//	public void setParentid(Long parentid) {
//		this.parentid = parentid;
//	}
//	public Long getUid() {
//		return uid;
//	}
//	public void setUid(Long uid) {
//		this.uid = uid;
//	}
//	public Long getTouid() {
//		return touid;
//	}
//	public void setTouid(Long touid) {
//		this.touid = touid;
//	}
//	public Long getPlaceid() {
//		return placeid;
//	}
//	public void setPlaceid(Long placeid) {
//		this.placeid = placeid;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getPics() {
//		return pics;
//	}
//	public void setPics(String pics) {
//		this.pics = pics;
//	}
//	public Integer getType() {
//		return type;
//	}
//	public void setType(Integer type) {
//		this.type = type;
//	}
//	public Integer getStatus() {
//		return status;
//	}
//	public void setStatus(Integer status) {
//		this.status = status;
//	}
//	public Double getScore() {
//		return score;
//	}
//	public void setScore(Double score) {
//		this.score = score;
//	}
//	public String getThirdwebid() {
//		return thirdwebid;
//	}
//	public void setThirdwebid(String thirdwebid) {
//		this.thirdwebid = thirdwebid;
//	}
//	public java.util.Date getCreatetime() {
//		return createtime;
//	}
//	public void setCreatetime(java.util.Date createtime) {
//		this.createtime = createtime;
//	}
//}
