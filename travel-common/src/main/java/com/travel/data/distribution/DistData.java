package com.travel.data.distribution;

import java.io.Serializable;

public class DistData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6182358287179538468L;
	private String source;
	private String url;
	private String cost;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
}
