package com.travel.entity.workflow;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.travel.entity.RawData;
@Entity
public class WorkflowDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 46516749511679440L;
	
	public final static int TYPE_AUTO_MERGE = RawData.STATUS_AUTO_MERGE;
	public final static int TYPE_AUTO_CREATE = RawData.STATUS_AUTO_CREATE;
	public final static int TYPE_MANNUL_MERGE = RawData.STATUS_MANNUL_MERGE;
	public final static int TYPE_MANNUL_CREATE = RawData.STATUS_MANNUL_CREATE;
	public final static int TYPE_MANNUL_TEST_CASE = 10;
	public final static int TYPE_RATECOUNT_SPLIT = 11;
	public final static int TYPE_MANNUL_SPLIT = 12;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer workflowId;
	private Integer rawId;
	private Integer comparedRawId;
	private Double score;
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String scoreDetail;
	private Integer status;
	private Long fromMergeId;
	private Long toMergeId;
	//rawData对应的mergeId关联的rawData数量
	private Integer num;
	private String username;
	private Date createTime = new Date();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}
	public Integer getRawId() {
		return rawId;
	}
	public void setRawId(Integer rawId) {
		this.rawId = rawId;
	}
	public Integer getComparedRawId() {
		return comparedRawId;
	}
	public void setComparedRawId(Integer comparedRawId) {
		this.comparedRawId = comparedRawId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getScoreDetail() {
		return scoreDetail;
	}
	public void setScoreDetail(String scoreDetail) {
		if(scoreDetail != null && scoreDetail.length() > 3000){
			scoreDetail = scoreDetail.substring(0, 3000);
		}
		this.scoreDetail = scoreDetail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Long getFromMergeId() {
		return fromMergeId;
	}
	public void setFromMergeId(Long fromMergeId) {
		this.fromMergeId = fromMergeId;
	}
	public Long getToMergeId() {
		return toMergeId;
	}
	public void setToMergeId(Long toMergeId) {
		this.toMergeId = toMergeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		WorkflowDetail other = (WorkflowDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
