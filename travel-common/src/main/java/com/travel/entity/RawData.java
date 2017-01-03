package com.travel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import net.sf.json.JSONArray;

import com.travel.data.ScoreInfo;
import com.travel.entity.mergeout.MergeOutDataModel;
import com.travel.generator.ChangeRecord;
import com.travel.generator.GeneratorRecord;

@Entity(name = "raw_data_mergeout")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mergedId", name = "mergeIdIdx") )
public class RawData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -40312205944007215L;
	public static int STATUS_DELETED = -1;
	public static int STATUS_NEW_NOT_PROCESSED = 0;
	public static int STATUS_NEW = 1;
	public static int STATUS_AUTO_MERGE = 2;
	public static int STATUS_AUTO_CREATE = 3;
	/**
	 * 人工手动指定的
	 */
	public static int STATUS_MANNUL_CREATE = 4;
	public static int STATUS_MANNUL_MERGE = 5;
	/**
	 * 等待人工去处理的
	 */
	public static int STATUS_WAIT = 6;
	/**
	 * 需人工处理且已Merge
	 */
	public static int STATUS_WAIT_AND_MERGE = 7;
	/**
	 * google经纬度校验错误
	 */
	public static final int RAW_DATA_GEO_ERROR = -20;
	/**
	 * 经纬度为null
	 */
	public static final int RAW_DATA_GEO_EMPTY = -21;
	/**
	 * country字段为null
	 */
	public static final int RAW_DTA_COUNTRY_EMPTY = -22;
	/**
	 * 商户已关闭或停业
	 */
	public static final int RAW_DATA_NAME_ILLEGAL = 8;
	/**
	 * 名字描述为 日游/day tours 的点
	 */
	public static final int RAW_DATA_DAY_TOURS = -32;
	/**
	 * 名字是酒店，但是type是购物
	 */
	public static final int RAW_DATA_GOUWU_HOTEL = -31;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Embedded
	private MergeOutDataModel mergeOutDataModel;
	// @Index(name="mergeIdIdx")
	private String mergedId;
	@Transient
	private Round1Info round1Info;

	@Transient
	public Map<String, Double> scoreDebugMap = new HashMap<String, Double>();
	@Transient
	public List<ChangeRecord> changeRecs = new ArrayList<ChangeRecord>();
	@Transient
	public Map<String, GeneratorRecord> generatorMap = new HashMap<String, GeneratorRecord>();
	@Transient
	private Integer isFetchComment;
	@Transient
	private String commentTs;
	@Transient
	private ScoreInfo score;
	@Transient
	private boolean isBadLocation;
	@Transient
	private boolean isBadData;
	@Transient
	public Map<String,Integer> unchangedFieldMap;
	
	public boolean isBadData() {
		return isBadData;
	}

	public void setBadData(boolean isBadData) {
		this.isBadData = isBadData;
	}

	public boolean isBadLocation() {
		return isBadLocation;
	}

	public void setBadLocation(boolean isBadLocation) {
		this.isBadLocation = isBadLocation;
	}

	public String getCommentTs() {
		return commentTs;
	}

	public void setCommentTs(String commentTs) {
		this.commentTs = commentTs;
	}

	public ScoreInfo getScore() {
		return score;
	}

	public void setScore(ScoreInfo score) {
		this.score = score;
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:").append(mergeOutDataModel.getPlaceInfo().getPlaceInfo_strName()).append(" ").append("region:")
				.append(mergeOutDataModel.getIdInfo().getIdInfo_strCity());
		return sb.toString();
	}

	public void changeRecord(String field, String from, String to) {
		ChangeRecord cr = new ChangeRecord();
		cr.setField(field);
		cr.setFrom(from);
		cr.setTo(to);
		this.changeRecs.add(cr);
	}

	public void keepChangeStr() {
		String c = JSONArray.fromObject(this.changeRecs).toString();
		if (c.length() > 5000) {
			c = c.substring(0, 4500) + "...";
		}
		mergeOutDataModel.setChangeStr(c);
	}

	public void recGenerator(String source, String field, String val) {
		GeneratorRecord gr = new GeneratorRecord();
		gr.setField(field);
		gr.setSource(source);
		gr.setVal(val);
		generatorMap.put(field, gr);
	}

	public void keepGeneratorRec() {
		Set<String> sources = new TreeSet<String>();
		for (GeneratorRecord gr : generatorMap.values()) {
			sources.add(gr.getSource());
		}
		mergeOutDataModel.setSourceList(JSONArray.fromObject(sources).toString());
		mergeOutDataModel.setGeneratorRecord(JSONArray.fromObject(generatorMap.values()).toString());
	}

	public void clearNoUseField() {
		mergeOutDataModel.getIdInfo().setIdInfo_strId("");
		mergeOutDataModel.getIdInfo().setIdInfo_strSource("");
		mergeOutDataModel.getIdInfo().setIdInfo_strURL("");
	}

	public Integer getIsFetchComment() {
		return isFetchComment;
	}

	public void setIsFetchComment(Integer isFetchComment) {
		this.isFetchComment = isFetchComment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MergeOutDataModel getMergeOutDataModel() {
		return mergeOutDataModel;
	}

	public void setMergeOutDataModel(MergeOutDataModel mergeOutDataModel) {
		this.mergeOutDataModel = mergeOutDataModel;
	}

	public String getMergedId() {
		return mergedId;
	}

	public void setMergedId(String mergedId) {
		this.mergedId = mergedId;
	}

	public Round1Info getRound1Info() {
		return round1Info;
	}

	public void setRound1Info(Round1Info round1Info) {
		this.round1Info = round1Info;
	}

	@Override
	public String toString() {
		return id + "";
	}

	public void init() {
		mergeOutDataModel = new MergeOutDataModel();
		IdInfo idInfo = new IdInfo();
		;
		MallInfo mallInfo = new MallInfo();
		PlaceInfo placeInfo = new PlaceInfo();
		PopularInfo popularInfo = new PopularInfo();
		RestaurantInfo restaurantInfo = new RestaurantInfo();
		ViewInfo viewInfo = new ViewInfo();
		HotelInfo hotelInfo = new HotelInfo();
		QualityInfo qualityInfo = new QualityInfo();
		mergeOutDataModel.setIdInfo(idInfo);
		mergeOutDataModel.setMailInfo(mallInfo);
		mergeOutDataModel.setPlaceInfo(placeInfo);
		mergeOutDataModel.setPopularInfo(popularInfo);
		popularInfo.setPopularInfo_strEnviromentScore(0.);
		popularInfo.setPopularInfo_strProductScore(0.);
		popularInfo.setPopularInfo_strRateCount(0.);
		popularInfo.setPopularInfo_strScore(0.);
		popularInfo.setPopularInfo_strServiceScore(0.);
		popularInfo.setPopularInfo_userCommentSize(0);
		mergeOutDataModel.setRestaurantInfo(restaurantInfo);
		mergeOutDataModel.setViewInfo(viewInfo);
		mergeOutDataModel.setHotelInfo(hotelInfo);
		mergeOutDataModel.setQualityInfo(qualityInfo);

		DistributionInfo distInfo = new DistributionInfo();
		mergeOutDataModel.setDistInfo(distInfo);
	}
}
