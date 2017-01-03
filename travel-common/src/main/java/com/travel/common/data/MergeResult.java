package com.travel.common.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.travel.data.RawDataBase;
import com.travel.entity.RawData;

public class MergeResult {
	private long cid;
	private long id;
	private String url;
	private String name;
	private String city;
	private String place;
	private String time;
	private String desc;
	private String cost;
	private String tel;
	private String alias;
	private String distance;
	private String idfSim;
	private String nonIdfSim;
	private String typeSim;
	private String debugInfo;
	private int status;
	private boolean mark = false;
	private double mannulScore = 0;
	/**
	 * 1:在测试集，不在真实集 2:在真实集，不在测试集 3:即在真实集，又在测试集
	 */
	private int markStatus;

	private String cluster;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getIdfSim() {
		return idfSim;
	}

	public void setIdfSim(String idfSim) {
		this.idfSim = idfSim;
	}

	public String getNonIdfSim() {
		return nonIdfSim;
	}

	public void setNonIdfSim(String nonIdfSim) {
		this.nonIdfSim = nonIdfSim;
	}

	public String getTypeSim() {
		return typeSim;
	}

	public void setTypeSim(String typeSim) {
		this.typeSim = typeSim;
	}

	public String getDebugInfo() {
		return debugInfo;
	}

	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}

	@Override
	public String toString() {
		return id + " : " + name + " : " + url;
	}

	public static MergeResult createMannulMergeResult(RawData rawData) {
		MergeResult result = new MergeResult();
		result.setId(rawData.getId());
		String country = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strCountry();
		String city = rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strCity();
		result.setCity(country + "_" + city);
		result.setAlias(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_listAliasName());
		result.setCost(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strCost());
		result.setDesc(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strDesc());
		result.setName(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strName());
		result.setPlace(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strAddress());
		result.setTel(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_listTelephone());
		result.setTime(rawData.getMergeOutDataModel().getPlaceInfo().getPlaceInfo_strOpenTime());
		result.setUrl(rawData.getMergeOutDataModel().getIdInfo().getIdInfo_strURL());
		result.setStatus(rawData.getMergeOutDataModel().getStatus());
		return result;
	}

	public static MergeResult createMannulMergeResult(RawDataBase rawData) {
		MergeResult result = new MergeResult();
		result.setId(rawData.getId());
		String country = rawData.idInfo.strCountry;
		String city = rawData.idInfo.strCity;
		result.setCity(country + "_" + city);
		result.setAlias(String.join("<br/>", rawData.placeInfo.listAliasName));
		result.setCost(rawData.placeInfo.strCost);
		result.setDesc(rawData.placeInfo.strDesc);
		result.setName(rawData.placeInfo.strName);
		result.setPlace(rawData.placeInfo.strAddress);
		result.setTel(String.join("<br/>", rawData.placeInfo.listTelephone));
		result.setTime(rawData.placeInfo.strOpenTime);
		result.setUrl(rawData.idInfo.strURL);
		result.setStatus(rawData.status);
		return result;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public int getMarkStatus() {
		return markStatus;
	}

	public void setMarkStatus(int markStatus) {
		this.markStatus = markStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getMannulScore() {
		return mannulScore;
	}

	public void setMannulScore(double mannulScore) {
		this.mannulScore = mannulScore;
	}

	public void setCluster(Set<String> realRawIdSet, Set<String> testRawIdSet) {
		List<String> cluster = new ArrayList<String>();
		cluster.add(String.valueOf(this.id));
		for (String rawId : testRawIdSet) {
			if (String.valueOf(this.id).equals(rawId)) {
				continue;
			}
			cluster.add(rawId);
		}
		for (String rawId : realRawIdSet) {
			if (String.valueOf(this.id).equals(rawId)) {
				continue;
			}
			cluster.add(rawId);
		}
		this.cluster = "rawId=" + String.join("&rawId=", cluster);
	}
}
