package com.travel.entity.report;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SourceReportItem implements Serializable {

	//加权信息完整度
	static final public Integer REPORT_TYPE_SOURCE_WITH_WEIGHT = 1;
	//平均信息完整度分数
	static final public Integer REPORT_TYPE_SOURCE_INFOSCORE_AVG = 3;
	//平均综合质量分数
	static final public Integer REPORT_TYPE_SOURCE_QUALITY_AVG = 4;
	//统计条数报表
	static final public Integer REPORT_TYPE_ENTITY_NUM = 5;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1366538880031892933L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String source;
	private String placeType;
	private Double score;
	private Integer scoreType;
	private Long reportId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getScoreType() {
		return scoreType;
	}
	public void setScoreType(Integer scoreType) {
		this.scoreType = scoreType;
	}
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
}
