package com.travel.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import util.StringNormalize;

@Embeddable
public class SynonymWordId implements Serializable {
	private static final long serialVersionUID = 1306259894836605599L;
	@Transient
	private String lWord;
	@Transient
	private String bWord;

	private String lNorWord;
	private String bNorWord;

	public SynonymWordId(){
		
	}
	
	public SynonymWordId(String word1, String word2) {
		String norWord1 = StringNormalize.normalize(word1);
		norWord1 = norWord1.replaceAll("[\\s]+", "");

		String norWord2 = StringNormalize.normalize(word2);
		norWord2 = norWord2.replaceAll("[\\s]+", "");

		if (norWord1.compareTo(norWord2) > 0) {
			lNorWord = norWord2;
			lWord = word2;
			bNorWord = norWord1;
			bWord = word1;
		} else {
			lNorWord = norWord1;
			lWord = word1;
			bNorWord = norWord2;
			bWord = word2;
		}
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

	public String getlNorWord() {
		return lNorWord;
	}

	public void setlNorWord(String lNorWord) {
		this.lNorWord = lNorWord;
	}

	public String getbNorWord() {
		return bNorWord;
	}

	public void setbNorWord(String bNorWord) {
		this.bNorWord = bNorWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bNorWord == null) ? 0 : bNorWord.hashCode());
		result = prime * result + ((lNorWord == null) ? 0 : lNorWord.hashCode());
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
		SynonymWordId other = (SynonymWordId) obj;
		if (bNorWord == null) {
			if (other.bNorWord != null)
				return false;
		} else if (!bNorWord.equals(other.bNorWord))
			return false;
		if (lNorWord == null) {
			if (other.lNorWord != null)
				return false;
		} else if (!lNorWord.equals(other.lNorWord))
			return false;
		return true;
	}
}
