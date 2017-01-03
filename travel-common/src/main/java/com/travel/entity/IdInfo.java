package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Index;

@Embeddable
public class IdInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1275459600672799164L;
	@Column(name="IdInfo_strSource" )
	private String IdInfo_strSource;
	@Column(name="IdInfo_strId")
	private String IdInfo_strId;
	@Column(name="IdInfo_strURL" )
	private String IdInfo_strURL;
	@Column(name="IdInfo_strCity" )
	private String IdInfo_strCity;
	@Column(name="IdInfo_strCountry")
	private String IdInfo_strCountry;
	@Column(name="IdInfo_strPlaceType")
//	@Index(name="place_type_idx")
	private String IdInfo_strPlaceType;
	public String getIdInfo_strSource() {
		return IdInfo_strSource;
	}
	public void setIdInfo_strSource(String idInfo_strSource) {
		IdInfo_strSource = idInfo_strSource;
	}
	public String getIdInfo_strId() {
		return IdInfo_strId;
	}
	public void setIdInfo_strId(String idInfo_strId) {
		IdInfo_strId = idInfo_strId;
	}
	public String getIdInfo_strURL() {
		return IdInfo_strURL;
	}
	public void setIdInfo_strURL(String idInfo_strURL) {
		IdInfo_strURL = idInfo_strURL;
	}
	public String getIdInfo_strCity() {
		return IdInfo_strCity;
	}
	public void setIdInfo_strCity(String idInfo_strCity) {
		IdInfo_strCity = idInfo_strCity;
	}
	public String getIdInfo_strCountry() {
		return IdInfo_strCountry;
	}
	public void setIdInfo_strCountry(String idInfo_strCountry) {
		IdInfo_strCountry = idInfo_strCountry;
	}
	public String getIdInfo_strPlaceType() {
		return IdInfo_strPlaceType;
	}
	public void setIdInfo_strPlaceType(String idInfo_strPlaceType) {
		IdInfo_strPlaceType = idInfo_strPlaceType;
	}
	
}
