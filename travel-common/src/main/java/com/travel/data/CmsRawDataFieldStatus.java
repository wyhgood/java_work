package com.travel.data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.travel.utils.StringUtils;

public class CmsRawDataFieldStatus {
	public static final int UNCHANGE = 1;
	public static final int MERGE = 2;
	private static final Map<String, Integer> statusMap = new HashMap<String, Integer>();
	static {
		statusMap.put("status", UNCHANGE);
		statusMap.put("PlaceInfo_strName", UNCHANGE);
		statusMap.put("IdInfo_strCountry", UNCHANGE);
		statusMap.put("IdInfo_strCity", UNCHANGE);
		statusMap.put("IdInfo_strPlaceType", UNCHANGE);

		statusMap.put("PlaceInfo_strAddress", UNCHANGE);
		statusMap.put("PlaceInfo_strLat", UNCHANGE);
		statusMap.put("PlaceInfo_strLng", UNCHANGE);
		statusMap.put("PlaceInfo_strCost", UNCHANGE);
		statusMap.put("PlaceInfo_strOpenTime", UNCHANGE);
		statusMap.put("PlaceInfo_listTelephone", UNCHANGE);
		statusMap.put("ViewInfo_strCostTime", UNCHANGE);

	}

	public Integer status;
	public Integer IdInfo_strCountry;
	public Integer IdInfo_strCity;
	public Integer IdInfo_strPlaceType;
	public Integer PlaceInfo_strName;

	public Integer PlaceInfo_strAddress;
	public Integer PlaceInfo_strLat;
	public Integer PlaceInfo_strLng;
	public Integer PlaceInfo_strCost;
	public Integer PlaceInfo_strOpenTime;
	public Integer ViewInfo_strCostTime;

	public int getStatus(String fieldName) {
		Integer fieldStatus = statusMap.get(fieldName);
		return fieldStatus == null ? 0 : fieldStatus;
	}

	/**
	 * 有一个字段被人工处理过，则返回true
	 * 
	 * @param unchanged
	 * @param fields
	 * @return
	 */
	public static boolean hasOneProcessed(String unchanged, String... fields) {
		// 无编辑记录
		if (StringUtils.isEmpty(unchanged)) {
			return false;
		}
		Map<String, Number> map = new HashMap<String, Number>();
		try {
			map = new Gson().fromJson(unchanged, Map.class);
		} catch (Exception e) {

		}
		for (String field : fields) {
			Number value = map.get(field);
			if (value != null && value.intValue() != 0) {
				return true;
			}
		}
		return false;
	}

	public void add(String fieldName) {
		try {
			Field field = this.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(this, getStatus(fieldName));
		} catch (NoSuchFieldException e) {
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
