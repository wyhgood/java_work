package com.travel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;
@Embeddable
public class MallInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4506029763618866734L;
	@Lob
	private String MallInfo_listPics;
	@Transient
	private List<String> listPics;
	@Transient
	private List<String> listRecommendShop;
	@Lob
	private String MallInfo_listRecommendShop;
	@Lob
	private String MallInfo_listMallType;
	@Lob
	private String MallInfo_listMallType_processed;
	public String getMallInfo_listMallType_processed() {
		return MallInfo_listMallType_processed;
	}
	public void setMallInfo_listMallType_processed(
			String mallInfo_listMallType_processed) {
		MallInfo_listMallType_processed = mallInfo_listMallType_processed;
	}
	public String getMallInfo_listMallType() {
		return MallInfo_listMallType;
	}
	public void setMallInfo_listMallType(String mallInfo_listMallType) {
		MallInfo_listMallType = mallInfo_listMallType;
	}
	public List<String> getListPics() {
		return listPics;
	}
	public void setListPics(List<String> listPics) {
		this.listPics = listPics;
	}
	public List<String> getListRecommendShop() {
		return listRecommendShop;
	}
	public void setListRecommendShop(List<String> listRecommendShop) {
		this.listRecommendShop = listRecommendShop;
	}
	public String getMallInfo_listPics() {
		return MallInfo_listPics;
	}
	public void setMallInfo_listPics(String mallInfo_listPics) {
		MallInfo_listPics = mallInfo_listPics;
	}
	public String getMallInfo_listRecommendShop() {
		return MallInfo_listRecommendShop;
	}
	public void setMallInfo_listRecommendShop(String mallInfo_listRecommendShop) {
		MallInfo_listRecommendShop = mallInfo_listRecommendShop;
	}
	
}
