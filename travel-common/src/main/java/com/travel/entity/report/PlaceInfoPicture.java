//package com.travel.entity.report;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity(name="place_info_picture")
//public class PlaceInfoPicture implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -1074152553942540621L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private Long placeid;
//	private String picture;
//	private Integer type;
//	private java.util.Date createtime;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Long getPlaceid() {
//		return placeid;
//	}
//	public void setPlaceid(Long placeid) {
//		this.placeid = placeid;
//	}
//	public String getPicture() {
//		return picture;
//	}
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
//	public Integer getType() {
//		return type;
//	}
//	public void setType(Integer type) {
//		this.type = type;
//	}
//	public java.util.Date getCreatetime() {
//		return createtime;
//	}
//	public void setCreatetime(java.util.Date createtime) {
//		this.createtime = createtime;
//	}
//}
