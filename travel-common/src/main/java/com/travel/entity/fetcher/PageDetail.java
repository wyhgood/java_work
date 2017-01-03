package com.travel.entity.fetcher;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Index;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(
		columnNames={"rawId","pageNumber"},name="uniqueIdx"))
public class PageDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1440837541907213701L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer pageNumber;
//	@Index(name="raw_id")
	private Long rawId;
	@Lob
	private String html;
	@Lob
	private String html_attach;
	public String getHtml_attach() {
		return html_attach;
	}
	public void setHtml_attach(String html_attach) {
		this.html_attach = html_attach;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Long getRawId() {
		return rawId;
	}
	public void setRawId(Long rawId) {
		this.rawId = rawId;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
}
