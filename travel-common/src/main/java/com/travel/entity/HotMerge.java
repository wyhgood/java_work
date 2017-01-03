package com.travel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import com.travel.data.HotMergeStatus;

@Entity
public class HotMerge {
	@Id
	private long placeid;
	private long mergeid;
	private String name;
	private String openTime;
	private String costTime;
	private String type;
	private String city;
	private String cityid;
	@Lob
	private String poOpenTime;
	private double poCostTime;
	private String lat;
	private String lng;

	private double rateCount;

	private String status;
	@Transient
	private String errMsg;

	private int cnName = 1;

	public long getPlaceid() {
		return placeid;
	}

	public void setPlaceid(long placeid) {
		this.placeid = placeid;
	}

	public long getMergeid() {
		return mergeid;
	}

	public void setMergeid(long mergeid) {
		this.mergeid = mergeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCostTime() {
		return costTime;
	}

	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}

	public String getPoOpenTime() {
		return poOpenTime;
	}

	public void setPoOpenTime(String poOpenTime) {
		this.poOpenTime = poOpenTime;
	}

	public double getPoCostTime() {
		return poCostTime;
	}

	public void setPoCostTime(double poCostTime) {
		this.poCostTime = poCostTime;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLocation() {
		return lat + "," + lng;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public void addStatus(int errStatus) {
		if (errStatus == HotMergeStatus.OK || errStatus == HotMergeStatus.MANNUL_OP) {
			this.status = String.valueOf(errStatus);
			return;
		}
		if (status == null) {
			status = "";
		}

		if (!status.contains(String.valueOf(errStatus))) {
			if (status.length() > 0) {
				status += "\001";
			}
			status += errStatus;
		}
	}

	public void computeStatus() {
		if ("jingdian".equals(type) || "yule".equals(type)) {
			if (poCostTime <= 0) {
				addStatus(HotMergeStatus.JINGDIAN_COST_TIME_EMPTY);
				addStatus(HotMergeStatus.JINGDIAN_COST_TIME);
			} else if (poCostTime >= 8) {
				addStatus(HotMergeStatus.JINGDIAN_COST_TIME_ALL_DAY);
				addStatus(HotMergeStatus.JINGDIAN_COST_TIME);
			}

			if (poOpenTime == null || poOpenTime.trim().length() == 0) {
				addStatus(HotMergeStatus.JINGDIAN_OPEN_TIME);
			} else {
				int count = 0;
				for (int index = 0; index < poOpenTime.length(); index++) {
					char c = poOpenTime.charAt(index);
					if (c == '1') {
						count++;
						// 连续8小时
						if (count > 16) {
							addStatus(HotMergeStatus.JINGDIAN_OPEN_TIME);
							break;
						}
					} else {
						count = 0;
					}
				}
			}
		}

		if ("gouwu".equals(type)) {
			if (poCostTime == 0 || poCostTime >= 24) {
				addStatus(HotMergeStatus.GOUWU_COST_TIME);
			}

			if (poOpenTime == null || poOpenTime.trim().length() == 0) {
				addStatus(HotMergeStatus.GOUWU_COST_TIME);
			} else {
				int count = 0;
				for (int index = 0; index < poOpenTime.length(); index++) {
					char c = poOpenTime.charAt(index);
					if (c == '1') {
						count++;
						// 连续8小时
						if (count > 16) {
							addStatus(HotMergeStatus.GOUWU_COST_TIME);
							break;
						}
					} else {
						count = 0;
					}
				}
			}
		}
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public double getRateCount() {
		return rateCount;
	}

	public void setRateCount(double rateCount) {
		this.rateCount = rateCount;
	}

	public int getCnName() {
		return cnName;
	}

	public void setCnName(int cnName) {
		this.cnName = cnName;
	}
}
