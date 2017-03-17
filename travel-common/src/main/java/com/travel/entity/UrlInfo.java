package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UrlInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1430592036992462523L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long urlId;
	private String urlMd5;
	private String url;
	private String src;
	private String pageType;
	private String subPageType;
	private String crawlIndex1;
	private String crawlIndex2;
	private String crawlIndex3;
	private String crawlFeature;
	private Integer crawlCount;
	private Integer errCount;
	public Long getUrlId() {
		return urlId;
	}
	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}
	public String getUrlMd5() {
		return urlMd5;
	}
	public void setUrlMd5(String urlMd5) {
		this.urlMd5 = urlMd5;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getSubPageType() {
		return subPageType;
	}
	public void setSubPageType(String subPageType) {
		this.subPageType = subPageType;
	}
	public String getCrawlIndex1() {
		return crawlIndex1;
	}
	public void setCrawlIndex1(String crawlIndex1) {
		this.crawlIndex1 = crawlIndex1;
	}
	public String getCrawlIndex2() {
		return crawlIndex2;
	}
	public void setCrawlIndex2(String crawlIndex2) {
		this.crawlIndex2 = crawlIndex2;
	}
	public String getCrawlIndex3() {
		return crawlIndex3;
	}
	public void setCrawlIndex3(String crawlIndex3) {
		this.crawlIndex3 = crawlIndex3;
	}
	public String getCrawlFeature() {
		return crawlFeature;
	}
	public void setCrawlFeature(String crawlFeature) {
		this.crawlFeature = crawlFeature;
	}
	public Integer getCrawlCount() {
		return crawlCount;
	}
	public void setCrawlCount(Integer crawlCount) {
		this.crawlCount = crawlCount;
	}
	public Integer getErrCount() {
		return errCount;
	}
	public void setErrCount(Integer errCount) {
		this.errCount = errCount;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getHtmlFormat() {
		return htmlFormat;
	}
	public void setHtmlFormat(String htmlFormat) {
		this.htmlFormat = htmlFormat;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getHtmlFeature() {
		return htmlFeature;
	}
	public void setHtmlFeature(String htmlFeature) {
		this.htmlFeature = htmlFeature;
	}
	public String getReferUrl() {
		return referUrl;
	}
	public void setReferUrl(String referUrl) {
		this.referUrl = referUrl;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	private Integer valid;
	private Integer status;
	private String htmlFormat;
	@Lob
	private String html;
	private String htmlFeature;
	private String referUrl;
	private String redirectUrl;
	private String createTime;
	private String updateTime;
	
	
}