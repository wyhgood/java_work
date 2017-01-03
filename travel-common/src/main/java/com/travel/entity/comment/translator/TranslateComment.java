package com.travel.entity.comment.translator;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="translate_comment")
public class TranslateComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6528183793080551977L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private TranslateModel translateModel;
	
	public TranslateModel getTranslateModel() {
		return translateModel;
	}
	public void setTranslateModel(TranslateModel translateModel) {
		this.translateModel = translateModel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
