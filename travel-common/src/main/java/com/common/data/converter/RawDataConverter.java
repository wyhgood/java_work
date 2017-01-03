package com.common.data.converter;

import java.util.Arrays;
import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.travel.data.IdInfo;
import com.travel.data.MallInfo;
import com.travel.data.PlaceInfo;
import com.travel.data.PopularInfo;
import com.travel.data.RawDataBase;
import com.travel.data.RestaurantInfo;
import com.travel.data.ViewInfo;
import com.travel.entity.RawData;
import com.travel.utils.TravelUtils;

@Component
public class RawDataConverter {

	public static LinkedList<String> arr2List(String[] arrs){
		if(arrs==null)return null;
		LinkedList<String> list = new LinkedList<String>();
		list.addAll(Arrays.asList(arrs));
		return list;
	}
	public static String[] safeSplit(String val,String delimeter){
		if(TravelUtils.isEmpty(val))return null;
		return val.split(delimeter);
	}
	private IdInfo createIdInfo(RawData rawData){
		IdInfo idInfo = new IdInfo();
		idInfo.strCity = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strCity();
		idInfo.strCountry = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strCountry();
		idInfo.strId = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strId();
		idInfo.strPlaceType = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strPlaceType();
		idInfo.strSource = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strSource();
		idInfo.strURL = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strURL();
		return idInfo;
	}
	private MallInfo createMallInfo(RawData rawData){
		MallInfo mallInfo = new MallInfo();
		mallInfo.listPics = arr2List(safeSplit(rawData.getMergeOutDataModel().getMailInfo().getMallInfo_listPics(),"\001"));
		mallInfo.listRecommendShop = arr2List(safeSplit(rawData.getMergeOutDataModel().getMailInfo()
				.getMallInfo_listRecommendShop(),"\001"));
		return mallInfo;
	}
	private PopularInfo createPopularInfo(RawData rawData){
		PopularInfo popularInfo = new PopularInfo();
		popularInfo.listTags = arr2List(safeSplit(rawData.getMergeOutDataModel().getPopularInfo().getPopularInfo_listTags(),"\001"));
		//popularInfo.listUserComment = 
		popularInfo.strEnviromentScore = rawData.getMergeOutDataModel().getPopularInfo().getPopularInfo_strEnviromentScore().toString();
		popularInfo.strProductScore = rawData.getMergeOutDataModel().getPopularInfo().getPopularInfo_strProductScore().toString();
		popularInfo.strRateCount = rawData.getMergeOutDataModel().getPopularInfo().getPopularInfo_strRateCount().toString();
		popularInfo.strScore = rawData.getMergeOutDataModel().getPopularInfo().getPopularInfo_strScore().toString();
		popularInfo.strServiceScore = rawData.getMergeOutDataModel().getPopularInfo().getPopularInfo_strServiceScore().toString();
		return popularInfo;
	}
	private PlaceInfo createPlaceInfo(RawData rawData){
		PlaceInfo placeInfo = new PlaceInfo();
		placeInfo.listAliasName = arr2List(safeSplit(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_listAliasName(),"\001"));
		placeInfo.listPics = arr2List(safeSplit(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_listPics(),"\001"));
		placeInfo.listTelephone = arr2List(safeSplit(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_listTelephone(),"\001"));
		placeInfo.strAddress = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strAddress();
		placeInfo.strCost = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strCost();
		placeInfo.strDesc = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strDesc();
		placeInfo.strLat = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strLat();
		placeInfo.strLng = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strLng();
		placeInfo.strMainPic = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strMainPic();
		placeInfo.strName = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strName();
		placeInfo.strOpenTime = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strOpenTime();
		placeInfo.strTraffic = rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strTraffic();
		return placeInfo;
	}
	private RestaurantInfo createRestauratInfo(RawData rawData){
		RestaurantInfo r = new RestaurantInfo();
		r.listFoodType = arr2List(safeSplit(rawData.getMergeOutDataModel().getRestaurantInfo().getRestaurantInfo_listFoodType(),"\001"));
		//r.listFoodWithPic = arr2List(rawData.getRestaurantInfo().getRestaurantInfo_listFoodWithPic().split("\001"));
		r.listRecommendFood = arr2List(safeSplit(rawData.getMergeOutDataModel().getRestaurantInfo().getRestaurantInfo_listRecommendFood(),"\001"));
		return r;
	}
	private ViewInfo createViewInfo(RawData rawData){
		ViewInfo c = new ViewInfo();
		c.listPic = arr2List(safeSplit(rawData.getMergeOutDataModel().getViewInfo().getViewInfo_listPic(),"\001"));
		c.listRecommendPlay = arr2List(safeSplit(rawData.getMergeOutDataModel().getViewInfo().getViewInfo_listRecommendPlay(),"\001"));
		c.strEntrancePrice = rawData.getMergeOutDataModel().getViewInfo().getViewInfo_strEntrancePrice();
		c.strCostTime = rawData.getMergeOutDataModel().getViewInfo().getViewInfo_strCostTime();
		return c;
	}
	public RawDataBase convert(RawData rawData){
		RawDataBase rawDataBase = new RawDataBase();
		rawDataBase.Init(rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strPlaceType());
		rawDataBase.idInfo = createIdInfo(rawData);
		rawDataBase.mallInfo = createMallInfo(rawData);
		rawDataBase.placeInfo = createPlaceInfo(rawData);
		rawDataBase.popularInfo = createPopularInfo(rawData);
		rawDataBase.restaurantInfo = createRestauratInfo(rawData);
		rawDataBase.viewInfo = createViewInfo(rawData);
		return rawDataBase;
	}
	
}
