package com.travel.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SynonymWord {
	@Id
	@Embedded
	private SynonymWordId synonymWordId;
	private String lWord;
	private String bWord;
	private String user;
	private Date createTime = new Date();

	public SynonymWordId getSynonymWordId() {
		return synonymWordId;
	}

	public void setSynonymWordId(SynonymWordId synonymWordId) {
		this.synonymWordId = synonymWordId;
		this.lWord = synonymWordId.getlWord();
		this.bWord = synonymWordId.getbWord();
	}

	public String getlWord() {
		return lWord;
	}

	public void setlWord(String lWord) {
		this.lWord = lWord;
	}

	public String getbWord() {
		return bWord;
	}

	public void setbWord(String bWord) {
		this.bWord = bWord;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
