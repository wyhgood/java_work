package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class HotelInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1820402481271661070L;
	private String HotelInfo_strStar;
	private String HotelInfo_strRoomNum;
	private String HotelInfo_listFacility;
	public String getHotelInfo_strStar() {
		return HotelInfo_strStar;
	}
	public void setHotelInfo_strStar(String hotelInfo_strStar) {
		HotelInfo_strStar = hotelInfo_strStar;
	}
	public String getHotelInfo_strRoomNum() {
		return HotelInfo_strRoomNum;
	}
	public void setHotelInfo_strRoomNum(String hotelInfo_strRoomNum) {
		HotelInfo_strRoomNum = hotelInfo_strRoomNum;
	}
	public String getHotelInfo_listFacility() {
		return HotelInfo_listFacility;
	}
	public void setHotelInfo_listFacility(String hotelInfo_listFacility) {
		HotelInfo_listFacility = hotelInfo_listFacility;
	}
	
}
