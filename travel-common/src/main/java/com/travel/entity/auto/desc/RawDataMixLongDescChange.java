package com.travel.entity.auto.desc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class RawDataMixLongDescChange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2469550941947422204L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private AutoDescModel autoDescModel;
	@Column(columnDefinition="varchar(1000)",length=1000)
	private String changeStr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AutoDescModel getAutoDescModel() {
		return autoDescModel;
	}
	public void setAutoDescModel(AutoDescModel autoDescModel) {
		this.autoDescModel = autoDescModel;
	}
	public String getChangeStr() {
		return changeStr;
	}
	public void setChangeStr(String changeStr) {
		this.changeStr = changeStr;
	}
}
