package com.travel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AgodaHotelRedirectUrlNativeRepository {
	@Autowired
	private NativeRepository nativeRepository;

	public List<String> findUrlByRedirectUrlIn(List<String> urlList) {
		if (urlList == null || urlList.isEmpty()) {
			return new ArrayList<String>();
		}
		String sql = "select url from agoda_hotel_redirect_url where redirect_url in ('" + String.join("', '", urlList) + "')";
		List<String> resultList = this.nativeRepository.queryStringResult(sql);
		return resultList;
	}
	
	public Map<String, String> findRedirectUrlMapping(List<String> urlList){
		Map<String, String> result = new HashMap<String, String>();
		if (urlList == null || urlList.isEmpty()) {
			return result;
		}
		
		String sql = "select url, redirect_url from agoda_hotel_redirect_url where redirect_url in ('" + String.join("', '", urlList) + "')";
		List<Object[]> queryResultList = this.nativeRepository.query(sql);
		for(Object[] queryResult : queryResultList){
			String url = (String) queryResult[0];
			String redirectUrl = (String) queryResult[1];
			result.put(url, redirectUrl);
		}
		
		return result;
	}
}
