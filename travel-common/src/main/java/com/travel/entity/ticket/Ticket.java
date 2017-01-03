package com.travel.entity.ticket;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1090131812691571803L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer rawId;
	private String mergeId;
	private String thirdId;
	private Double price;
	@Column(columnDefinition="varchar(50)",length=50)
	private String name;
	@Column(columnDefinition="varchar(50)",length=50)
	private String districtName;
	@Column(columnDefinition="varchar(50)",length=50)
	private String countryName;
//	@Column(columnDefinition="varchar(5000)",length=5000)
	@Lob
	private String detailJson;
	private Double lat;
	private Double lng;
	private Double commentGrade;
	private Double commentUserCount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	public String getMergeId() {
		return mergeId;
	}
	public void setMergeId(String mergeId) {
		this.mergeId = mergeId;
	}
	public String getThirdId() {
		return thirdId;
	}
	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDetailJson() {
		return detailJson;
	}
	public void setDetailJson(String detailJson) {
		this.detailJson = detailJson;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getCommentGrade() {
		return commentGrade;
	}
	public void setCommentGrade(Double commentGrade) {
		this.commentGrade = commentGrade;
	}
	public Double getCommentUserCount() {
		return commentUserCount;
	}
	public void setCommentUserCount(Double commentUserCount) {
		this.commentUserCount = commentUserCount;
	}
	public void copyTo(Ticket ticket){
		ticket.setCountryName(countryName);
		ticket.setDetailJson(detailJson);
		ticket.setDistrictName(districtName);
		ticket.setLat(lat);
		ticket.setLng(lng);
		ticket.setName(name);
		ticket.setPrice(price);
	}
}
