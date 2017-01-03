package com.travel.entity.route;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import com.travel.data.route.RoutePoiData;
@Entity
public class RouteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1666858131800184014L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String city;
	@Column(columnDefinition="varchar(10000)",length=3000)
	private String details;
	private String url;
	@Transient
	private List<RoutePoiData> routePoiData;
	@Lob
	private String pageDetail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public List<RoutePoiData> getRoutePoiData() {
		return routePoiData;
	}
	public void setRoutePoiData(List<RoutePoiData> routePoiData) {
		this.routePoiData = routePoiData;
	}
	public String getPageDetail() {
		return pageDetail;
	}
	public void setPageDetail(String pageDetail) {
		this.pageDetail = pageDetail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void init(){
		routePoiData = new ArrayList<RoutePoiData>();
	}
	public void printLog(){
		for(RoutePoiData rpd:routePoiData){
			System.out.println("day:" + rpd.getDayIdx() + " subIdx:"
					+ rpd.getSubIdx() + " poi:" + rpd.getPoiid() + " name:"
					+ rpd.getName());
		}
	}
}
