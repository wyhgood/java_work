//package com.travel.entity.report;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity(name="place_area_relation")
//public class PlaceAreaRelation implements Serializable{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 127860294107123202L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer id;
//	private String name;
//	private String alias;
//	private Integer level;
//	private Integer placeType;
//	private String picture;
//	private Integer fid;
//	private java.util.Date updatetime;
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getAlias() {
//		return alias;
//	}
//	public void setAlias(String alias) {
//		this.alias = alias;
//	}
//	public Integer getLevel() {
//		return level;
//	}
//	public void setLevel(Integer level) {
//		this.level = level;
//	}
//	public Integer getPlaceType() {
//		return placeType;
//	}
//	public void setPlaceType(Integer placeType) {
//		this.placeType = placeType;
//	}
//	public String getPicture() {
//		return picture;
//	}
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
//	public Integer getFid() {
//		return fid;
//	}
//	public void setFid(Integer fid) {
//		this.fid = fid;
//	}
//	public java.util.Date getUpdatetime() {
//		return updatetime;
//	}
//	public void setUpdatetime(java.util.Date updatetime) {
//		this.updatetime = updatetime;
//	}
//}
