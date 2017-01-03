package com.travel.entity.tag;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.travel.data.tag.Tag;
@Entity
@Table(uniqueConstraints=@UniqueConstraint(
		columnNames={"rawId","userCommentId"},name="uniqueIdx"))
public class TagData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8054277938004663516L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long rawId;
	private Long userCommentId;
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String brands;
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String tags;
	@Transient
	private List<Tag> brandList;
	@Transient
	private List<Tag> tagList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRawId() {
		return rawId;
	}
	public void setRawId(Long rawId) {
		this.rawId = rawId;
	}
	public Long getUserCommentId() {
		return userCommentId;
	}
	public void setUserCommentId(Long userCommentId) {
		this.userCommentId = userCommentId;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public List<Tag> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<Tag> brandList) {
		this.brandList = brandList;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
}
