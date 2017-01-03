package com.travel.entity.classifier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class PoiTagStatistic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6059933188061015281L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer mergeId;
	private Integer placeId;
	private Integer foodTagNum;
	private Integer shoppingTagNum;
	private Integer viewTagNum;
	private Integer hotelTagNum;
	@Lob
	private String foodTagJson;
	@Lob
	private String shoppngTagJson;
	@Lob
	private String hotelTagJson;
	@Lob
	private String viewTagJson;
	
	public String getFoodTagJson() {
		return foodTagJson;
	}
	public void setFoodTagJson(String foodTagJson) {
		this.foodTagJson = foodTagJson;
	}
	public String getShoppngTagJson() {
		return shoppngTagJson;
	}
	public void setShoppngTagJson(String shoppngTagJson) {
		this.shoppngTagJson = shoppngTagJson;
	}
	public String getHotelTagJson() {
		return hotelTagJson;
	}
	public void setHotelTagJson(String hotelTagJson) {
		this.hotelTagJson = hotelTagJson;
	}
	public String getViewTagJson() {
		return viewTagJson;
	}
	public void setViewTagJson(String viewTagJson) {
		this.viewTagJson = viewTagJson;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFoodTagNum() {
		return foodTagNum;
	}
	public void setFoodTagNum(Integer foodTagNum) {
		this.foodTagNum = foodTagNum;
	}
	public Integer getShoppingTagNum() {
		return shoppingTagNum;
	}
	public void setShoppingTagNum(Integer shoppingTagNum) {
		this.shoppingTagNum = shoppingTagNum;
	}
	public Integer getViewTagNum() {
		return viewTagNum;
	}
	public void setViewTagNum(Integer viewTagNum) {
		this.viewTagNum = viewTagNum;
	}
	public Integer getHotelTagNum() {
		return hotelTagNum;
	}
	public void setHotelTagNum(Integer hotelTagNum) {
		this.hotelTagNum = hotelTagNum;
	}
	public Integer getMergeId() {
		return mergeId;
	}
	public void setMergeId(Integer mergeId) {
		this.mergeId = mergeId;
	}
	public Integer getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}
}
