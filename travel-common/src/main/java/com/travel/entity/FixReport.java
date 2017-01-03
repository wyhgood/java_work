package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FixReport implements Serializable {
	private static final long serialVersionUID = -1727811450601215836L;

	public static final int TYPE_SPLIT = 1;
	public static final int TYPE_MERGE = 2;
	public static final int TYPE_ALL = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int workflowId;
	private String city;
	private long mergeId;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getMergeId() {
		return mergeId;
	}

	public void setMergeId(long mergeId) {
		this.mergeId = mergeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (mergeId ^ (mergeId >>> 32));
		result = prime * result + type;
		result = prime * result + workflowId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FixReport other = (FixReport) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (mergeId != other.mergeId)
			return false;
		if (type != other.type)
			return false;
		if (workflowId != other.workflowId)
			return false;
		return true;
	}
}
