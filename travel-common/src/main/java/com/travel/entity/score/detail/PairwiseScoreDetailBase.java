package com.travel.entity.score.detail;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

import com.travel.entity.RawData;

@Embeddable
public class PairwiseScoreDetailBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3429814142549924950L;
	//smaller rawid
	private Integer sRawId;
	//larger rawid
	private Integer lRawId;
	//length of name
	private Integer sRawDataWordNameLen;
	private Integer lRawDataWordNameLen;
	//char length of name
	private Integer sRawDataCharNameLen;
	private Integer lRawDataCharNameLen;
	//分词后的名称tfidf向量空间相似度
	private Double nameVecTfidfSegSimScore;
	private Double nameVecTfidfSegSimScoreNorm;
	//分词后的名称非tfidf向量空间相似度
	private Double nameVecSegSimScore;
	private Double nameVecSegSimScoreNorm;
	//名称字符非tfidf向量空间相似度
	private Double nameVecCharSimScore;
	private Double nameVecCharSimScoreNorm;
	//名称bigram tfidf向量空间相似度
	private Double nameVecTfidfBigramSimScore;
	private Double nameVecTfidfBigramSimScoreNorm;
	//名称bigram(非tfidf)向量空间相似度
	private Double nameVecBigramSimScore;
	private Double nameVecBigramSimScoreNorm;
	//名称word匹配长度 最长公共子串
	private Integer nameSimWordMatchLen;
	private Double nameSimWordMatchLenNorm;
	//名称word匹配长度比例 最长公共子串
	private Double nameSimWordMatchRate;
	private Double nameSimWordMatchLenRateNorm;
	//名称char匹配长度
	private Integer nameSimCharMatchLen;
	private Integer nameSimCharMatchLenNorm;
	//名称char匹配长度比例
	private Integer nameSimCharMatchRate;
	private Integer nameSimCharMatchRateNorm;
	//名称编辑距离
	private Double nameEditDistance;
	private Double nameEditDistanceNorm;
	//名称编辑距离
	private Double nameEditDistanceRate;
	private Double nameEditDistanceRateNorm;
	//词袋匹配
	private Integer nameWordSetMatchLen;
	private Double nameWordSetMatchLenNorm;
	//词袋匹配
	private Double nameWordSetMatchLenRate;
	private Double nameWordSetMatchLenRateNorm;
	//名称是否包含
	private Double isNameContain;
	private Double nameContainNorm;
	//电话号码是否匹配
	private Double isPhoneSame;
	private Double isPhoneSameNorm;
	//距离
	private Double distance;
	private Double distanceNorm;
	//类别是否一致，比如，寺庙=寺
	private Double isEntityTypeMatch;
	private Double isEntityTypeMatchNorm;
	//地址相似度
	private Double addressSimScore;
	private Double addressSimScoreNorm;
	//描述的相似程度
	private Double descSimScore;
	private Double descSimSocreNorm;
	//描述与对方的名称的包含程度
	private Double descContainNameRate;
	private Double descContainNameRateNorm;
	//分店名是否一致 "1：分店名称相同 -1：分店名称不同 0：无法确定分店名是否相同（如，其中一个没有明显的分店名）"
	private Double isBranchNameMatch;
	private Double isBranchNameMatchNorm;
	//poi 类别是否一致
	private Double placeTypeSimScore;
	private Double placeTypeSimScoreNorm;
	//<5000, >10000
	private Double totalScore;
	private Integer currentStatus;
	private Integer scoreStatus;
	private Integer isBaseData;
	@Lob
	private String debugInfo;
	private Integer version;
	
	@Transient
	private RawData sRawData;
	
	@Transient
	private RawData lRawData;
	
	public Integer getsRawId() {
		return sRawId;
	}
	public void setsRawId(Integer sRawId) {
		this.sRawId = sRawId;
	}
	public Integer getlRawId() {
		return lRawId;
	}
	public void setlRawId(Integer lRawId) {
		this.lRawId = lRawId;
	}
	public Integer getsRawDataWordNameLen() {
		return sRawDataWordNameLen;
	}
	public void setsRawDataWordNameLen(Integer sRawDataWordNameLen) {
		this.sRawDataWordNameLen = sRawDataWordNameLen;
	}
	public Integer getlRawDataWordNameLen() {
		return lRawDataWordNameLen;
	}
	public void setlRawDataWordNameLen(Integer lRawDataWordNameLen) {
		this.lRawDataWordNameLen = lRawDataWordNameLen;
	}
	public Integer getsRawDataCharNameLen() {
		return sRawDataCharNameLen;
	}
	public void setsRawDataCharNameLen(Integer sRawDataCharNameLen) {
		this.sRawDataCharNameLen = sRawDataCharNameLen;
	}
	public Integer getlRawDataCharNameLen() {
		return lRawDataCharNameLen;
	}
	public void setlRawDataCharNameLen(Integer lRawDataCharNameLen) {
		this.lRawDataCharNameLen = lRawDataCharNameLen;
	}
	public Double getNameVecTfidfSegSimScore() {
		return nameVecTfidfSegSimScore;
	}
	public void setNameVecTfidfSegSimScore(Double nameVecTfidfSegSimScore) {
		this.nameVecTfidfSegSimScore = nameVecTfidfSegSimScore;
	}
	public Double getNameVecTfidfSegSimScoreNorm() {
		return nameVecTfidfSegSimScoreNorm;
	}
	public void setNameVecTfidfSegSimScoreNorm(Double nameVecTfidfSegSimScoreNorm) {
		this.nameVecTfidfSegSimScoreNorm = nameVecTfidfSegSimScoreNorm;
	}
	public Double getNameVecCharSimScore() {
		return nameVecCharSimScore;
	}
	public void setNameVecCharSimScore(Double nameVecCharSimScore) {
		this.nameVecCharSimScore = nameVecCharSimScore;
	}
	public Double getNameVecCharSimScoreNorm() {
		return nameVecCharSimScoreNorm;
	}
	public void setNameVecCharSimScoreNorm(Double nameVecCharSimScoreNorm) {
		this.nameVecCharSimScoreNorm = nameVecCharSimScoreNorm;
	}
	public Double getNameVecTfidfBigramSimScore() {
		return nameVecTfidfBigramSimScore;
	}
	public void setNameVecTfidfBigramSimScore(Double nameVecTfidfBigramSimScore) {
		this.nameVecTfidfBigramSimScore = nameVecTfidfBigramSimScore;
	}
	public Double getNameVecTfidfBigramSimScoreNorm() {
		return nameVecTfidfBigramSimScoreNorm;
	}
	public void setNameVecTfidfBigramSimScoreNorm(
			Double nameVecTfidfBigramSimScoreNorm) {
		this.nameVecTfidfBigramSimScoreNorm = nameVecTfidfBigramSimScoreNorm;
	}
	public Double getNameVecBigramSimScore() {
		return nameVecBigramSimScore;
	}
	public void setNameVecBigramSimScore(Double nameVecBigramSimScore) {
		this.nameVecBigramSimScore = nameVecBigramSimScore;
	}
	public Double getNameVecBigramSimScoreNorm() {
		return nameVecBigramSimScoreNorm;
	}
	public void setNameVecBigramSimScoreNorm(Double nameVecBigramSimScoreNorm) {
		this.nameVecBigramSimScoreNorm = nameVecBigramSimScoreNorm;
	}
	public Integer getNameSimWordMatchLen() {
		return nameSimWordMatchLen;
	}
	public void setNameSimWordMatchLen(Integer nameSimWordMatchLen) {
		this.nameSimWordMatchLen = nameSimWordMatchLen;
	}
	public Double getNameSimWordMatchLenNorm() {
		return nameSimWordMatchLenNorm;
	}
	public void setNameSimWordMatchLenNorm(Double nameSimWordMatchLenNorm) {
		this.nameSimWordMatchLenNorm = nameSimWordMatchLenNorm;
	}
	public Double getNameSimWordMatchRate() {
		return nameSimWordMatchRate;
	}
	public void setNameSimWordMatchRate(Double nameSimWordMatchRate) {
		this.nameSimWordMatchRate = nameSimWordMatchRate;
	}
	public Double getNameSimWordMatchLenRateNorm() {
		return nameSimWordMatchLenRateNorm;
	}
	public void setNameSimWordMatchLenRateNorm(Double nameSimWordMatchLenRateNorm) {
		this.nameSimWordMatchLenRateNorm = nameSimWordMatchLenRateNorm;
	}
	public Integer getNameSimCharMatchLen() {
		return nameSimCharMatchLen;
	}
	public void setNameSimCharMatchLen(Integer nameSimCharMatchLen) {
		this.nameSimCharMatchLen = nameSimCharMatchLen;
	}
	public Integer getNameSimCharMatchLenNorm() {
		return nameSimCharMatchLenNorm;
	}
	public void setNameSimCharMatchLenNorm(Integer nameSimCharMatchLenNorm) {
		this.nameSimCharMatchLenNorm = nameSimCharMatchLenNorm;
	}
	public Integer getNameSimCharMatchRate() {
		return nameSimCharMatchRate;
	}
	public void setNameSimCharMatchRate(Integer nameSimCharMatchRate) {
		this.nameSimCharMatchRate = nameSimCharMatchRate;
	}
	public Integer getNameSimCharMatchRateNorm() {
		return nameSimCharMatchRateNorm;
	}
	public void setNameSimCharMatchRateNorm(Integer nameSimCharMatchRateNorm) {
		this.nameSimCharMatchRateNorm = nameSimCharMatchRateNorm;
	}
	public Double getNameEditDistance() {
		return nameEditDistance;
	}
	public void setNameEditDistance(Double nameEditDistance) {
		this.nameEditDistance = nameEditDistance;
	}
	public Double getNameEditDistanceNorm() {
		return nameEditDistanceNorm;
	}
	public void setNameEditDistanceNorm(Double nameEditDistanceNorm) {
		this.nameEditDistanceNorm = nameEditDistanceNorm;
	}
	public Integer getNameWordSetMatchLen() {
		return nameWordSetMatchLen;
	}
	public void setNameWordSetMatchLen(Integer nameWordSetMatchLen) {
		this.nameWordSetMatchLen = nameWordSetMatchLen;
	}
	public Double getNameWordSetMatchLenNorm() {
		return nameWordSetMatchLenNorm;
	}
	public void setNameWordSetMatchLenNorm(Double nameWordSetMatchLenNorm) {
		this.nameWordSetMatchLenNorm = nameWordSetMatchLenNorm;
	}
	public Double getIsNameContain() {
		return isNameContain;
	}
	public void setIsNameContain(Double isNameContain) {
		this.isNameContain = isNameContain;
	}
	public Double getNameContainNorm() {
		return nameContainNorm;
	}
	public void setNameContainNorm(Double nameContainNorm) {
		this.nameContainNorm = nameContainNorm;
	}
	public Double getIsPhoneSame() {
		return isPhoneSame;
	}
	public void setIsPhoneSame(Double isPhoneSame) {
		this.isPhoneSame = isPhoneSame;
	}
	public Double getIsPhoneSameNorm() {
		return isPhoneSameNorm;
	}
	public void setIsPhoneSameNorm(Double isPhoneSameNorm) {
		this.isPhoneSameNorm = isPhoneSameNorm;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getDistanceNorm() {
		return distanceNorm;
	}
	public void setDistanceNorm(Double distanceNorm) {
		this.distanceNorm = distanceNorm;
	}
	public Double getIsEntityTypeMatch() {
		return isEntityTypeMatch;
	}
	public void setIsEntityTypeMatch(Double isEntityTypeMatch) {
		this.isEntityTypeMatch = isEntityTypeMatch;
	}
	public Double getIsEntityTypeMatchNorm() {
		return isEntityTypeMatchNorm;
	}
	public void setIsEntityTypeMatchNorm(Double isEntityTypeMatchNorm) {
		this.isEntityTypeMatchNorm = isEntityTypeMatchNorm;
	}
	public Double getAddressSimScore() {
		return addressSimScore;
	}
	public void setAddressSimScore(Double addressSimScore) {
		this.addressSimScore = addressSimScore;
	}
	public Double getAddressSimScoreNorm() {
		return addressSimScoreNorm;
	}
	public void setAddressSimScoreNorm(Double addressSimScoreNorm) {
		this.addressSimScoreNorm = addressSimScoreNorm;
	}
	public Double getDescSimScore() {
		return descSimScore;
	}
	public void setDescSimScore(Double descSimScore) {
		this.descSimScore = descSimScore;
	}
	public Double getDescSimSocreNorm() {
		return descSimSocreNorm;
	}
	public void setDescSimSocreNorm(Double descSimSocreNorm) {
		this.descSimSocreNorm = descSimSocreNorm;
	}
	public Double getDescContainNameRate() {
		return descContainNameRate;
	}
	public void setDescContainNameRate(Double descContainNameRate) {
		this.descContainNameRate = descContainNameRate;
	}
	public Double getDescContainNameRateNorm() {
		return descContainNameRateNorm;
	}
	public void setDescContainNameRateNorm(Double descContainNameRateNorm) {
		this.descContainNameRateNorm = descContainNameRateNorm;
	}
	public Double getIsBranchNameMatch() {
		return isBranchNameMatch;
	}
	public void setIsBranchNameMatch(Double isBranchNameMatch) {
		this.isBranchNameMatch = isBranchNameMatch;
	}
	public Double getIsBranchNameMatchNorm() {
		return isBranchNameMatchNorm;
	}
	public void setIsBranchNameMatchNorm(Double isBranchNameMatchNorm) {
		this.isBranchNameMatchNorm = isBranchNameMatchNorm;
	}
	public Double getPlaceTypeSimScore() {
		return placeTypeSimScore;
	}
	public void setPlaceTypeSimScore(Double placeTypeSimScore) {
		this.placeTypeSimScore = placeTypeSimScore;
	}
	public Double getPlaceTypeSimScoreNorm() {
		return placeTypeSimScoreNorm;
	}
	public void setPlaceTypeSimScoreNorm(Double placeTypeSimScoreNorm) {
		this.placeTypeSimScoreNorm = placeTypeSimScoreNorm;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Integer getScoreStatus() {
		return scoreStatus;
	}
	public void setScoreStatus(Integer scoreStatus) {
		this.scoreStatus = scoreStatus;
	}
	public Integer getIsBaseData() {
		return isBaseData;
	}
	public void setIsBaseData(Integer isBaseData) {
		this.isBaseData = isBaseData;
	}
	public String getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public RawData getsRawData() {
		return sRawData;
	}
	public void setsRawData(RawData sRawData) {
		this.sRawData = sRawData;
	}
	public RawData getlRawData() {
		return lRawData;
	}
	public void setlRawData(RawData lRawData) {
		this.lRawData = lRawData;
	}
	public Double getNameEditDistanceRate() {
		return nameEditDistanceRate;
	}
	public void setNameEditDistanceRate(Double nameEditDistanceRate) {
		this.nameEditDistanceRate = nameEditDistanceRate;
	}
	public Double getNameEditDistanceRateNorm() {
		return nameEditDistanceRateNorm;
	}
	public void setNameEditDistanceRateNorm(Double nameEditDistanceRateNorm) {
		this.nameEditDistanceRateNorm = nameEditDistanceRateNorm;
	}
	public Double getNameWordSetMatchLenRate() {
		return nameWordSetMatchLenRate;
	}
	public void setNameWordSetMatchLenRate(Double nameWordSetMatchLenRate) {
		this.nameWordSetMatchLenRate = nameWordSetMatchLenRate;
	}
	public Double getNameWordSetMatchLenRateNorm() {
		return nameWordSetMatchLenRateNorm;
	}
	public void setNameWordSetMatchLenRateNorm(Double nameWordSetMatchLenRateNorm) {
		this.nameWordSetMatchLenRateNorm = nameWordSetMatchLenRateNorm;
	}
	public Double getNameVecSegSimScore() {
		return nameVecSegSimScore;
	}
	public void setNameVecSegSimScore(Double nameVecSegSimScore) {
		this.nameVecSegSimScore = nameVecSegSimScore;
	}
	public Double getNameVecSegSimScoreNorm() {
		return nameVecSegSimScoreNorm;
	}
	public void setNameVecSegSimScoreNorm(Double nameVecSegSimScoreNorm) {
		this.nameVecSegSimScoreNorm = nameVecSegSimScoreNorm;
	}
}
