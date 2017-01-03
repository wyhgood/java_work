package com.travel.entity.comment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserNameMapping implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 752213261243621246L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String userNameFrom;
	private String userNameTo;
	private String comment_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserNameFrom() {
		return userNameFrom;
	}
	public void setUserNameFrom(String userNameFrom) {
		this.userNameFrom = userNameFrom;
	}
	public String getUserNameTo() {
		return userNameTo;
	}
	public void setUserNameTo(String userNameTo) {
		this.userNameTo = userNameTo;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
}
