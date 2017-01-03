package com.travel.entity.brand;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="dish_info")
public class DishInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2888078672639236519L;
	final static public int TYPE_COMMENT = 1;
	final static public int TYPE_WEBSITE = 2;
	final static public int TYPE_MANUAL = 3;
	final static public int TYPE_RESTAURANT = 4;//推荐菜
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nameZh;
	private String nameZhLowerCase;
	private String nameEn;
	private String nameEnLowerCase;
	private String other;
	private Integer type;
	private Date ts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getNameZhLowerCase() {
		return nameZhLowerCase;
	}
	public void setNameZhLowerCase(String nameZhLowerCase) {
		this.nameZhLowerCase = nameZhLowerCase;
	}
	public String getNameEnLowerCase() {
		return nameEnLowerCase;
	}
	public void setNameEnLowerCase(String nameEnLowerCase) {
		this.nameEnLowerCase = nameEnLowerCase;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
}
