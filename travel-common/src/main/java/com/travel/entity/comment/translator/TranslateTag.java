package com.travel.entity.comment.translator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="translate_tag")
public class TranslateTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1783198097390340259L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// tag 对应的短句
	@Column(columnDefinition="varchar(300)",length=300)
	private String tagSubSentence;
	// tag 对应的短句翻译成的句子
	@Column(columnDefinition="varchar(300)",length=300)
	private String tagDistSentence;
	@Embedded
	private TranslateModel translateModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagSubSentence() {
		return tagSubSentence;
	}

	public void setTagSubSentence(String tagSubSentence) {
		this.tagSubSentence = tagSubSentence;
	}

	public String getTagDistSentence() {
		return tagDistSentence;
	}

	public void setTagDistSentence(String tagDistSentence) {
		this.tagDistSentence = tagDistSentence;
	}

	public TranslateModel getTranslateModel() {
		return translateModel;
	}

	public void setTranslateModel(TranslateModel transModel) {
		this.translateModel = transModel;
	}

}
