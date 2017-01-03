package com.travel.entity.auto.desc;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class RawDataLongDesc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185162232587882731L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private AutoDescModel autoDescModel;
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
}
