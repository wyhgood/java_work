package com.travel.entity.mergeout;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	

@Entity
public class RawDataMergeOutChange implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6223877740531304336L;
	static public final Integer CHANGE_TYPE_MODIFY = 1;
	static public final Integer CHANGE_TYPE_NEW = 0;
	static public final Integer CHANGE_TYPE_DELETE = -1;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer mergeOutId;
	@Embedded
	private MergeOutDataModel mergeOutDataModel;
//	@Index(name="merge_id_index")
	private String mergedId;
	
	private Integer changeType;
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
	public Integer getMergeOutId() {
		return mergeOutId;
	}
	public void setMergeOutId(Integer mergeOutId) {
		this.mergeOutId = mergeOutId;
	}
	public Integer getChangeType() {
		return changeType;
	}
	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}
}
