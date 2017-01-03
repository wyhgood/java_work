//package com.travel.entity.report;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//@Entity(name="place_info_recommend")
//public class PlaceInfoRecommend implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -7378338633297450266L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private Long placeid;
//	private String name;
//	private String namelocal;
//	private Double pricermb;
//	private Double pricelocal;
//	private String pics;
//	private Integer type;
//	private java.sql.Date createtime;
//	private java.util.Date updatetime;
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
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getNamelocal() {
//		return namelocal;
//	}
//	public void setNamelocal(String namelocal) {
//		this.namelocal = namelocal;
//	}
//	public Double getPricermb() {
//		return pricermb;
//	}
//	public void setPricermb(Double pricermb) {
//		this.pricermb = pricermb;
//	}
//	public Double getPricelocal() {
//		return pricelocal;
//	}
//	public void setPricelocal(Double pricelocal) {
//		this.pricelocal = pricelocal;
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
//	public java.sql.Date getCreatetime() {
//		return createtime;
//	}
//	public void setCreatetime(java.sql.Date createtime) {
//		this.createtime = createtime;
//	}
//	public java.util.Date getUpdatetime() {
//		return updatetime;
//	}
//	public void setUpdatetime(java.util.Date updatetime) {
//		this.updatetime = updatetime;
//	}
//}
