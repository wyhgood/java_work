package com.travel.entity.brand;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="brand_info_new")
//@Table(uniqueConstraints={
//		@UniqueConstraint(columnNames={"nameEnLowerCase","type"},name="mergeIdIdx"),
//		@UniqueConstraint(columnNames={"nameEnLowerCase","type"},name="mergeIdIdx")
//		})
public class BrandInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7361556856803704147L;
	//化妆品
	final static public int TYPE_MAKEUP=1;
	//饰品
	final static public int TYPE_ACCESSORY=2;
	//奢侈品
	final static public int TYPE_LUXURY = 3;
	//电子产品
	final static public int TYPE_EPROD = 4;
	//香水
	final static public int TYPE_PERFUME = 5;
	//婴儿
	final static public int TYPE_BABY = 6;
	//时尚
	final static public int TYPE_FASHION = 7;
	//食品
	final static public int TYPE_FOOD = 8;
	//百货
	final static public int TYPE_MERCHANDISE = 9;
	//运动
	final static public int TYPE_SPORTS = 10;
	//钟表
	final static public int TYPE_WATCH = 11;
	
	final static public int TYPE_DEFAULT = 0;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nameEnLowerCase;
	private String nameEn;
	private String nameZh;
	private String nameZhLowerCase;
	private String alias;
	private int type;
	private Date ts;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getNameEnLowerCase() {
		return nameEnLowerCase;
	}
	public void setNameEnLowerCase(String nameEnLowerCase) {
		this.nameEnLowerCase = nameEnLowerCase;
	}
	public String getNameZhLowerCase() {
		return nameZhLowerCase;
	}
	public void setNameZhLowerCase(String nameZhLowerCase) {
		this.nameZhLowerCase = nameZhLowerCase;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
}
