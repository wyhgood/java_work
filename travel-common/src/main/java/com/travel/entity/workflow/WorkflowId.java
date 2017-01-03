package com.travel.entity.workflow;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class WorkflowId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1385074367981693922L;
	static public final int TYPE_WORKFLOW = 1;
	static public final int TYPE_FIXJOB = 2;
	static public final int TYPE_SUBJOB = 3;
	static public final int TYPE_FIXJOB_FROM_CREATE2MERGE = 4;
	static public final int TYPE_FIXJOB_FROM_MERGE2CREATE = 5;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer status;
	private Integer type;
	private Integer processCount;
	private Date ts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getProcessCount() {
		return processCount;
	}
	public void setProcessCount(Integer processCount) {
		this.processCount = processCount;
	}
	
}
