package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MannulCompareScoreId implements Serializable {
	private static final long serialVersionUID = -5268063188267983526L;

	private Long lRawId;
	private Long bRawId;

	public MannulCompareScoreId() {

	}

	public MannulCompareScoreId(long lRawId, long bRawId) {
		this.lRawId = Math.min(lRawId, bRawId);
		this.bRawId = Math.max(lRawId, bRawId);
	}

	public Long getbRawId() {
		return bRawId;
	}

	public void setbRawId(Long bRawId) {
		this.bRawId = bRawId;
	}

	public Long getlRawId() {
		return lRawId;
	}

	public void setlRawId(Long lRawId) {
		this.lRawId = lRawId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bRawId == null) ? 0 : bRawId.hashCode());
		result = prime * result + ((lRawId == null) ? 0 : lRawId.hashCode());
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
		MannulCompareScoreId other = (MannulCompareScoreId) obj;
		if (bRawId == null) {
			if (other.bRawId != null)
				return false;
		} else if (!bRawId.equals(other.bRawId))
			return false;
		if (lRawId == null) {
			if (other.lRawId != null)
				return false;
		} else if (!lRawId.equals(other.lRawId))
			return false;
		return true;
	}
}
