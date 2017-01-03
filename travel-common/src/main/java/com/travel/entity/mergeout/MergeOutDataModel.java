package com.travel.entity.mergeout;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Lob;

import com.travel.entity.DistributionInfo;
import com.travel.entity.HotelInfo;
import com.travel.entity.IdInfo;
import com.travel.entity.MallInfo;
import com.travel.entity.PlaceInfo;
import com.travel.entity.PopularInfo;
import com.travel.entity.QualityInfo;
import com.travel.entity.RestaurantInfo;
import com.travel.entity.ViewInfo;
@Embeddable
public class MergeOutDataModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1712288800609236447L;
	@Embedded
	private IdInfo idInfo;
	@Embedded
	private MallInfo mailInfo;
	@Embedded
	private PlaceInfo placeInfo;
	@Embedded
	private PopularInfo popularInfo;
	@Embedded
	private RestaurantInfo restaurantInfo;
	@Embedded
	private ViewInfo viewInfo;
	@Embedded
	private HotelInfo hotelInfo;
	@Embedded
	private QualityInfo qualityInfo;
	@Embedded
	private DistributionInfo distInfo;
	
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String scoreDebug;
	//@Column(columnDefinition="varchar(5000)",length=5000)
	@Lob
	private String changeStr;
	@Column(columnDefinition="varchar(2000)",length=2000)
	private String sourceList;
	@Lob
	private String generatorRecord;
	
	private Integer status;
//	@Index(name="ts_index")
	private Date ts;
	private Double quality;
	
	
	public IdInfo getIdInfo() {
		return idInfo;
	}
	public void setIdInfo(IdInfo idInfo) {
		this.idInfo = idInfo;
	}
	public MallInfo getMailInfo() {
		return mailInfo;
	}
	public void setMailInfo(MallInfo mailInfo) {
		this.mailInfo = mailInfo;
	}
	public PlaceInfo getPlaceInfo() {
		return placeInfo;
	}
	public void setPlaceInfo(PlaceInfo placeInfo) {
		this.placeInfo = placeInfo;
	}
	public PopularInfo getPopularInfo() {
		return popularInfo;
	}
	public void setPopularInfo(PopularInfo popularInfo) {
		this.popularInfo = popularInfo;
	}
	public RestaurantInfo getRestaurantInfo() {
		return restaurantInfo;
	}
	public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
		this.restaurantInfo = restaurantInfo;
	}
	public ViewInfo getViewInfo() {
		return viewInfo;
	}
	public void setViewInfo(ViewInfo viewInfo) {
		this.viewInfo = viewInfo;
	}
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	public QualityInfo getQualityInfo() {
		return qualityInfo;
	}
	public void setQualityInfo(QualityInfo qualityInfo) {
		this.qualityInfo = qualityInfo;
	}
	public String getScoreDebug() {
		return scoreDebug;
	}
	public void setScoreDebug(String scoreDebug) {
		this.scoreDebug = scoreDebug;
	}
	public String getChangeStr() {
		return changeStr;
	}
	public void setChangeStr(String changeStr) {
		this.changeStr = changeStr;
	}
	public String getSourceList() {
		return sourceList;
	}
	public void setSourceList(String sourceList) {
		this.sourceList = sourceList;
	}
	public String getGeneratorRecord() {
		return generatorRecord;
	}
	public void setGeneratorRecord(String generatorRecord) {
		this.generatorRecord = generatorRecord;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public Double getQuality() {
		return quality;
	}
	public void setQuality(Double quality) {
		this.quality = quality;
	}
	public DistributionInfo getDistInfo() {
		return distInfo;
	}
	public void setDistInfo(DistributionInfo distInfo) {
		this.distInfo = distInfo;
	}
}
