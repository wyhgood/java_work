//package com.travel.entity.report;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity(name="place_info")
//public class PlaceInfoNew implements Serializable{
//
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 856843830038226770L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private String name;
//	private String alias;
//	@Column(name="[desc]")
//	private String description;
//	private Integer type;
//	private String address;
//	private String travel;
//	private String openingtime;
//	private String phone;
//	private Integer country;
//	private Integer city;
//	private Double latitude;
//	private Double longitude;
//	private Double cost;
//	private Double score;
//	private Integer scorenum;
//	@Column(columnDefinition="double default '0.0'")
//	private Double infoscore;
//	private Integer quality;
//	private Integer commentnum;
//	private Integer laudnum;
//	private Long mergeid;
//	private Long auditid;
//	private String unchanged;
//	private Integer status;
//	private java.sql.Date createtime;
//	private java.util.Date updatetime;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
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
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public Integer getType() {
//		return type;
//	}
//	public void setType(Integer type) {
//		this.type = type;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getTravel() {
//		return travel;
//	}
//	public void setTravel(String travel) {
//		this.travel = travel;
//	}
//	public String getOpeningtime() {
//		return openingtime;
//	}
//	public void setOpeningtime(String openingtime) {
//		this.openingtime = openingtime;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public Integer getCountry() {
//		return country;
//	}
//	public void setCountry(Integer country) {
//		this.country = country;
//	}
//	public Integer getCity() {
//		return city;
//	}
//	public void setCity(Integer city) {
//		this.city = city;
//	}
//	public Double getLatitude() {
//		return latitude;
//	}
//	public void setLatitude(Double latitude) {
//		this.latitude = latitude;
//	}
//	public Double getCost() {
//		return cost;
//	}
//	public void setCost(Double cost) {
//		this.cost = cost;
//	}
//	public Double getScore() {
//		return score;
//	}
//	public void setScore(Double score) {
//		this.score = score;
//	}
//	public Integer getScorenum() {
//		return scorenum;
//	}
//	public void setScorenum(Integer scorenum) {
//		this.scorenum = scorenum;
//	}
//	public Integer getQuality() {
//		return quality;
//	}
//	public void setQuality(Integer quality) {
//		this.quality = quality;
//	}
//	public Integer getCommentnum() {
//		return commentnum;
//	}
//	public void setCommentnum(Integer commentnum) {
//		this.commentnum = commentnum;
//	}
//	public Integer getLaudnum() {
//		return laudnum;
//	}
//	public void setLaudnum(Integer laudnum) {
//		this.laudnum = laudnum;
//	}
//	public Long getMergeid() {
//		return mergeid;
//	}
//	public void setMergeid(Long mergeid) {
//		this.mergeid = mergeid;
//	}
//	public Long getAuditid() {
//		return auditid;
//	}
//	public void setAuditid(Long auditid) {
//		this.auditid = auditid;
//	}
//	public String getUnchanged() {
//		return unchanged;
//	}
//	public void setUnchanged(String unchanged) {
//		this.unchanged = unchanged;
//	}
//	public Integer getStatus() {
//		return status;
//	}
//	public void setStatus(Integer status) {
//		this.status = status;
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
//	public Double getLongitude() {
//		return longitude;
//	}
//	public void setLongitude(Double longitude) {
//		this.longitude = longitude;
//	}
//	public Double getInfoscore() {
//		return infoscore;
//	}
//	public void setInfoscore(Double infoscore) {
//		this.infoscore = infoscore;
//	}
//}
