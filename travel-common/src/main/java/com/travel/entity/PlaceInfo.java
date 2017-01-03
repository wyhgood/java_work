package com.travel.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;
@Embeddable
public class PlaceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9179222389743977455L;
	private String PlaceInfo_strLat;
	private String PlaceInfo_strLng;
//	@Index(name="nameIdx")
	private String PlaceInfo_strName;
	private String PlaceInfo_strBranchName;
	@Lob
	private String PlaceInfo_strAddress;
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String PlaceInfo_strOpenTime;
//	@Column(columnDefinition="varchar(500)",length=500)
	@Lob
	private String PlaceInfo_strOpenTimeBits;
	@Column(columnDefinition="int default '0'")
	private Integer PlaceInfo_isOpenTime_Processed;
	@Lob
	private String PlaceInfo_strTraffic;
	private String PlaceInfo_strMainPic;
	@Transient
	private int PlaceInfo_strMainPic_width;
	
	@Column(columnDefinition="varchar(200)",length=200)
	private String PlaceInfo_strPoLocalName;
	@Column(columnDefinition="varchar(200)",length=200)
	private String PlaceInfo_strPoEnName;
	@Column(columnDefinition="varchar(200)",length=200)
	private String PlaceInfo_strPoCnName;
	@Lob
	private String PlaceInfo_strPoLocalAddress;
	@Lob
	private String PlaceInfo_strPoEnAddress;
	@Lob
	private String PlaceInfo_strPoCnAddress;
	
	public String getPlaceInfo_strOpenTimeBits() {
		return PlaceInfo_strOpenTimeBits;
	}
	public void setPlaceInfo_strOpenTimeBits(String placeInfo_strOpenTimeBits) {
		PlaceInfo_strOpenTimeBits = placeInfo_strOpenTimeBits;
	}
	public String getPlaceInfo_strStreetAddress() {
		return PlaceInfo_strStreetAddress;
	}
	public void setPlaceInfo_strStreetAddress(String placeInfo_strStreetAddress) {
		PlaceInfo_strStreetAddress = placeInfo_strStreetAddress;
	}
	public String getPlaceInfo_strExtAddress() {
		return PlaceInfo_strExtAddress;
	}
	public void setPlaceInfo_strExtAddress(String placeInfo_strExtAddress) {
		PlaceInfo_strExtAddress = placeInfo_strExtAddress;
	}
	public String getPlaceInfo_strLocality() {
		return PlaceInfo_strLocality;
	}
	public void setPlaceInfo_strLocality(String placeInfo_strLocality) {
		PlaceInfo_strLocality = placeInfo_strLocality;
	}
	public String getPlaceInfo_strCountry() {
		return PlaceInfo_strCountry;
	}
	public void setPlaceInfo_strCountry(String placeInfo_strCountry) {
		PlaceInfo_strCountry = placeInfo_strCountry;
	}
	public String getPlaceInfo_strPostCode() {
		return PlaceInfo_strPostCode;
	}
	public void setPlaceInfo_strPostCode(String placeInfo_strPostCode) {
		PlaceInfo_strPostCode = placeInfo_strPostCode;
	}
	public String getPlaceInfo_strLocalStreetAddress() {
		return PlaceInfo_strLocalStreetAddress;
	}
	public void setPlaceInfo_strLocalStreetAddress(
			String placeInfo_strLocalStreetAddress) {
		PlaceInfo_strLocalStreetAddress = placeInfo_strLocalStreetAddress;
	}
	public String getPlaceInfo_strLocalExtAddress() {
		return PlaceInfo_strLocalExtAddress;
	}
	public void setPlaceInfo_strLocalExtAddress(String placeInfo_strLocalExtAddress) {
		PlaceInfo_strLocalExtAddress = placeInfo_strLocalExtAddress;
	}
	public String getPlaceInfo_strLocalLocality() {
		return PlaceInfo_strLocalLocality;
	}
	public void setPlaceInfo_strLocalLocality(String placeInfo_strLocalLocality) {
		PlaceInfo_strLocalLocality = placeInfo_strLocalLocality;
	}
	public String getPlaceInfo_strLocalCountry() {
		return PlaceInfo_strLocalCountry;
	}
	public void setPlaceInfo_strLocalCountry(String placeInfo_strLocalCountry) {
		PlaceInfo_strLocalCountry = placeInfo_strLocalCountry;
	}
	public String getPlaceInfo_strLocalPostCode() {
		return PlaceInfo_strLocalPostCode;
	}
	public void setPlaceInfo_strLocalPostCode(String placeInfo_strLocalPostCode) {
		PlaceInfo_strLocalPostCode = placeInfo_strLocalPostCode;
	}
	public String getPlaceInfo_strLocalName() {
		return PlaceInfo_strLocalName;
	}
	public void setPlaceInfo_strLocalName(String placeInfo_strLocalName) {
		PlaceInfo_strLocalName = placeInfo_strLocalName;
	}
	public String getPlaceInfo_strRegion() {
		return PlaceInfo_strRegion;
	}
	public void setPlaceInfo_strRegion(String placeInfo_strRegion) {
		PlaceInfo_strRegion = placeInfo_strRegion;
	}
	public String getPlaceInfo_strLocalRegion() {
		return PlaceInfo_strLocalRegion;
	}
	public void setPlaceInfo_strLocalRegion(String placeInfo_strLocalRegion) {
		PlaceInfo_strLocalRegion = placeInfo_strLocalRegion;
	}
//	public int getPlaceInfo_strMainPic_width() {
//		return PlaceInfo_strMainPic_width;
//	}
//	public void setPlaceInfo_strMainPic_width(int placeInfo_strMainPic_width) {
//		PlaceInfo_strMainPic_width = placeInfo_strMainPic_width;
//	}
	@Lob
	private String PlaceInfo_strDesc;
	@Lob
	private String PlaceInfo_strCost;
	@Column(columnDefinition="int default '0'")
	private Integer PlaceInfo_strCost_isPredict;
	@Lob  
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String PlaceInfo_listTelephone;
	@Transient
	private List<String> listTelephone;
	@Column(columnDefinition="varchar(1000)",length=1000)
	private String PlaceInfo_listAliasName;
	@Transient
	private List<String> listAliasName;
	@Lob
	private String PlaceInfo_listPics;
	
	@Transient
	private List<String> listPics;
	
	private String PlaceInfo_strStreetAddress;
	private String PlaceInfo_strExtAddress;
	private String PlaceInfo_strLocality;
	private String PlaceInfo_strCountry;
	private String PlaceInfo_strPostCode;
	private String PlaceInfo_strLocalStreetAddress;
	private String PlaceInfo_strLocalExtAddress;
	private String PlaceInfo_strLocalLocality;
	private String PlaceInfo_strLocalCountry;
	private String PlaceInfo_strLocalPostCode;
	private String PlaceInfo_strLocalName;
	private String PlaceInfo_strRegion;
	private String PlaceInfo_strLocalRegion;
	
	@Transient
	private Map<String,Double> imageWidthMap;
	public Map<String, Double> getImageWidthMap() {
		return imageWidthMap;
	}
	public void setImageWidthMap(Map<String, Double> imageWidthMap) {
		this.imageWidthMap = imageWidthMap;
	}
	public void recordImageWidth(String name,Double width){
		if(imageWidthMap==null){
			imageWidthMap = new HashMap<String,Double>();
		}
		imageWidthMap.put(name, width);
	}
	public double getImageWidth(String name){
		if(imageWidthMap==null){
			imageWidthMap = new HashMap<String,Double>();
		}
		Double w = imageWidthMap.get(name);
		return w==null?0:w;
	}
	
	public List<String> getListTelephone() {
		return listTelephone;
	}
	public void setListTelephone(List<String> listTelephone) {
		this.listTelephone = listTelephone;
	}
	public List<String> getListAliasName() {
		return listAliasName;
	}
	public void setListAliasName(List<String> listAliasName) {
		this.listAliasName = listAliasName;
	}
	public List<String> getListPics() {
		return listPics;
	}
	public void setListPics(List<String> listPics) {
		this.listPics = listPics;
	}
	public String getPlaceInfo_strLat() {
		return PlaceInfo_strLat;
	}
	public void setPlaceInfo_strLat(String placeInfo_strLat) {
		PlaceInfo_strLat = placeInfo_strLat;
	}
	public String getPlaceInfo_strLng() {
		return PlaceInfo_strLng;
	}
	public void setPlaceInfo_strLng(String placeInfo_strLng) {
		PlaceInfo_strLng = placeInfo_strLng;
	}
	public String getPlaceInfo_strName() {
		return PlaceInfo_strName;
	}
	public void setPlaceInfo_strName(String placeInfo_strName) {
		PlaceInfo_strName = placeInfo_strName;
	}
	public String getPlaceInfo_strAddress() {
		return PlaceInfo_strAddress;
	}
	public void setPlaceInfo_strAddress(String placeInfo_strAddress) {
		PlaceInfo_strAddress = placeInfo_strAddress;
	}
	public String getPlaceInfo_strOpenTime() {
		return PlaceInfo_strOpenTime;
	}
	public void setPlaceInfo_strOpenTime(String placeInfo_strOpenTime) {
		PlaceInfo_strOpenTime = placeInfo_strOpenTime;
	}
	public String getPlaceInfo_strTraffic() {
		return PlaceInfo_strTraffic;
	}
	public void setPlaceInfo_strTraffic(String placeInfo_strTraffic) {
		PlaceInfo_strTraffic = placeInfo_strTraffic;
	}
	public String getPlaceInfo_strMainPic() {
		return PlaceInfo_strMainPic;
	}
	public void setPlaceInfo_strMainPic(String placeInfo_strMainPic) {
		PlaceInfo_strMainPic = placeInfo_strMainPic;
	}
	public String getPlaceInfo_strDesc() {
		return PlaceInfo_strDesc;
	}
	public void setPlaceInfo_strDesc(String placeInfo_strDesc) {
		PlaceInfo_strDesc = placeInfo_strDesc;
	}
	public String getPlaceInfo_strCost() {
		return PlaceInfo_strCost;
	}
	public void setPlaceInfo_strCost(String placeInfo_strCost) {
		PlaceInfo_strCost = placeInfo_strCost;
	}
	public String getPlaceInfo_listTelephone() {
		return PlaceInfo_listTelephone;
	}
	public void setPlaceInfo_listTelephone(String placeInfo_listTelephone) {
		PlaceInfo_listTelephone = placeInfo_listTelephone;
	}
	public String getPlaceInfo_listAliasName() {
		return PlaceInfo_listAliasName;
	}
	public void setPlaceInfo_listAliasName(String placeInfo_listAliasName) {
		PlaceInfo_listAliasName = placeInfo_listAliasName;
	}
	public String getPlaceInfo_listPics() {
		return PlaceInfo_listPics;
	}
	public void setPlaceInfo_listPics(String placeInfo_listPics) {
		PlaceInfo_listPics = placeInfo_listPics;
	}
	public String getPlaceInfo_strBranchName() {
		return PlaceInfo_strBranchName;
	}
	public void setPlaceInfo_strBranchName(String placeInfo_strBranchName) {
		PlaceInfo_strBranchName = placeInfo_strBranchName;
	}
	public Integer getPlaceInfo_isOpenTime_Processed() {
		return PlaceInfo_isOpenTime_Processed;
	}
	public void setPlaceInfo_isOpenTime_Processed(
			Integer placeInfo_isOpenTime_Processed) {
		PlaceInfo_isOpenTime_Processed = placeInfo_isOpenTime_Processed;
	}
	public Integer getPlaceInfo_strCost_isPredict() {
		return PlaceInfo_strCost_isPredict;
	}
	public void setPlaceInfo_strCost_isPredict(Integer placeInfo_strCost_isPredict) {
		PlaceInfo_strCost_isPredict = placeInfo_strCost_isPredict;
	}
	public String getPlaceInfo_strPoLocalName() {
		return PlaceInfo_strPoLocalName;
	}
	public void setPlaceInfo_strPoLocalName(String placeInfo_strPoLocalName) {
		PlaceInfo_strPoLocalName = placeInfo_strPoLocalName;
	}
	public String getPlaceInfo_strPoEnName() {
		return PlaceInfo_strPoEnName;
	}
	public void setPlaceInfo_strPoEnName(String placeInfo_strPoEnName) {
		PlaceInfo_strPoEnName = placeInfo_strPoEnName;
	}
	public String getPlaceInfo_strPoCnName() {
		return PlaceInfo_strPoCnName;
	}
	public void setPlaceInfo_strPoCnName(String placeInfo_strPoCnName) {
		PlaceInfo_strPoCnName = placeInfo_strPoCnName;
	}
	public String getPlaceInfo_strPoLocalAddress() {
		return PlaceInfo_strPoLocalAddress;
	}
	public void setPlaceInfo_strPoLocalAddress(String placeInfo_strPoLocalAddress) {
		PlaceInfo_strPoLocalAddress = placeInfo_strPoLocalAddress;
	}
	public String getPlaceInfo_strPoEnAddress() {
		return PlaceInfo_strPoEnAddress;
	}
	public void setPlaceInfo_strPoEnAddress(String placeInfo_strPoEnAddress) {
		PlaceInfo_strPoEnAddress = placeInfo_strPoEnAddress;
	}
	public String getPlaceInfo_strPoCnAddress() {
		return PlaceInfo_strPoCnAddress;
	}
	public void setPlaceInfo_strPoCnAddress(String placeInfo_strPoCnAddress) {
		PlaceInfo_strPoCnAddress = placeInfo_strPoCnAddress;
	}
}
