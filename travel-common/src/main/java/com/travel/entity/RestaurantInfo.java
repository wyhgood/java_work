package com.travel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;
@Embeddable
public class RestaurantInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -90374727232803071L;
	@Lob
	private String RestaurantInfo_listRecommendFood;
	@Lob
	private String RestaurantInfo_listFoodWithPic;
	@Lob
	private String RestaurantInfo_listFoodType;
	@Lob
	private String RestaurantInfo_listFoodType_processed;
	@Transient
	private List<String> lstRecommendFood;
	@Transient
	private List<String> listFoodWithPic;
	@Transient
	private List<String> listFoodType;
	
	public List<String> getLstRecommendFood() {
		return lstRecommendFood;
	}
	public void setLstRecommendFood(List<String> lstRecommendFood) {
		this.lstRecommendFood = lstRecommendFood;
	}
	public List<String> getListFoodWithPic() {
		return listFoodWithPic;
	}
	public void setListFoodWithPic(List<String> listFoodWithPic) {
		this.listFoodWithPic = listFoodWithPic;
	}
	public List<String> getListFoodType() {
		return listFoodType;
	}
	public void setListFoodType(List<String> listFoodType) {
		this.listFoodType = listFoodType;
	}
	public String getRestaurantInfo_listRecommendFood() {
		return RestaurantInfo_listRecommendFood;
	}
	public void setRestaurantInfo_listRecommendFood(
			String restaurantInfo_listRecommendFood) {
		RestaurantInfo_listRecommendFood = restaurantInfo_listRecommendFood;
	}
	public String getRestaurantInfo_listFoodWithPic() {
		return RestaurantInfo_listFoodWithPic;
	}
	public void setRestaurantInfo_listFoodWithPic(
			String restaurantInfo_listFoodWithPic) {
		RestaurantInfo_listFoodWithPic = restaurantInfo_listFoodWithPic;
	}
	public String getRestaurantInfo_listFoodType() {
		return RestaurantInfo_listFoodType;
	}
	public void setRestaurantInfo_listFoodType(String restaurantInfo_listFoodType) {
		RestaurantInfo_listFoodType = restaurantInfo_listFoodType;
	}
	public String getRestaurantInfo_listFoodType_processed() {
		return RestaurantInfo_listFoodType_processed;
	}
	public void setRestaurantInfo_listFoodType_processed(
			String restaurantInfo_listFoodType_processed) {
		RestaurantInfo_listFoodType_processed = restaurantInfo_listFoodType_processed;
	}
}
