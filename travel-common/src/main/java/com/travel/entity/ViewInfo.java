package com.travel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;
@Embeddable
public class ViewInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3972043792788845869L;
	private String ViewInfo_strEntrancePrice;
	@Lob
	private String ViewInfo_listPic;
	@Lob
	private String ViewInfo_listRecommendPlay;
	@Column(columnDefinition="varchar(800)",length=800)
	private String ViewInfo_listViewType;
	@Transient
	private List<String> listPic;
	@Transient
	private List<String> listRecommendPlay;
	
	private String ViewInfo_strCostTime;
	@Column(columnDefinition="varchar(10)",length=10)
	private String ViewInfo_strCostTimeHour;
	
	private Integer ViewInfo_strCostTime_processed;
	public Integer getViewInfo_strCostTime_processed() {
		return ViewInfo_strCostTime_processed;
	}
	public void setViewInfo_strCostTime_processed(
			Integer viewInfo_strCostTime_processed) {
		ViewInfo_strCostTime_processed = viewInfo_strCostTime_processed;
	}
	public String getViewInfo_strEntrancePrice() {
		return ViewInfo_strEntrancePrice;
	}
	public void setViewInfo_strEntrancePrice(String viewInfo_strEntrancePrice) {
		ViewInfo_strEntrancePrice = viewInfo_strEntrancePrice;
	}
	public String getViewInfo_listPic() {
		return ViewInfo_listPic;
	}
	public void setViewInfo_listPic(String viewInfo_listPic) {
		ViewInfo_listPic = viewInfo_listPic;
	}
	public String getViewInfo_listRecommendPlay() {
		return ViewInfo_listRecommendPlay;
	}
	public void setViewInfo_listRecommendPlay(String viewInfo_listRecommendPlay) {
		ViewInfo_listRecommendPlay = viewInfo_listRecommendPlay;
	}
	public List<String> getListPic() {
		return listPic;
	}
	public void setListPic(List<String> listPic) {
		this.listPic = listPic;
	}
	public List<String> getListRecommendPlay() {
		return listRecommendPlay;
	}
	public void setListRecommendPlay(List<String> listRecommendPlay) {
		this.listRecommendPlay = listRecommendPlay;
	}
	public String getViewInfo_strCostTime() {
		return ViewInfo_strCostTime;
	}
	public void setViewInfo_strCostTime(String viewInfo_strCostTime) {
		ViewInfo_strCostTime = viewInfo_strCostTime;
	}
	public String getViewInfo_listViewType() {
		return ViewInfo_listViewType;
	}
	public void setViewInfo_listViewType(String viewInfo_listViewType) {
		ViewInfo_listViewType = viewInfo_listViewType;
	}
	public String getViewInfo_strCostTimeHour() {
		return ViewInfo_strCostTimeHour;
	}
	public void setViewInfo_strCostTimeHour(String viewInfo_strCostTimeHour) {
		ViewInfo_strCostTimeHour = viewInfo_strCostTimeHour;
	}
}
