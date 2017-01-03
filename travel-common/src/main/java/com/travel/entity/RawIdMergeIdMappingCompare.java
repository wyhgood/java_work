package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "rawid_mergeid_mapping_compare")
public class RawIdMergeIdMappingCompare implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6844336020035148013L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String testRawIds;
	private String realRawIds;
	private Long compareId;
	private int status = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestRawIds() {
		return testRawIds;
	}

	public void setTestRawIds(String testRawIds) {
		this.testRawIds = testRawIds;
	}

	public String getRealRawIds() {
		return realRawIds;
	}

	public void setRealRawIds(String realRawIds) {
		this.realRawIds = realRawIds;
	}

	public Long getCompareId() {
		return compareId;
	}

	public void setCompareId(Long compareId) {
		this.compareId = compareId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compareId == null) ? 0 : compareId.hashCode());
		result = prime * result + ((realRawIds == null) ? 0 : realRawIds.hashCode());
		result = prime * result + ((testRawIds == null) ? 0 : testRawIds.hashCode());
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
		RawIdMergeIdMappingCompare other = (RawIdMergeIdMappingCompare) obj;
		if (compareId == null) {
			if (other.compareId != null)
				return false;
		} else if (!compareId.equals(other.compareId))
			return false;
		if (realRawIds == null) {
			if (other.realRawIds != null)
				return false;
		} else if (!realRawIds.equals(other.realRawIds))
			return false;
		if (testRawIds == null) {
			if (other.testRawIds != null)
				return false;
		} else if (!testRawIds.equals(other.testRawIds))
			return false;
		return true;
	}
}
