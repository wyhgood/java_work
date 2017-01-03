package com.travel.data;

import java.util.ArrayList;
import java.util.List;

public class AnalyzedName {
	public List<AnalyzedWord> listAnalyzedWords = new ArrayList<AnalyzedWord>();
	public String strName = "";
	public String nameType = "";

	public String toReadableString() {
		String strReturn = "";
		for (AnalyzedWord analyzedWord : listAnalyzedWords) {
			strReturn += " " + analyzedWord.toReadableString();
		}

		return strReturn;
	}

	public AnalyzedName copy() {
		AnalyzedName name = new AnalyzedName();
		name.strName = strName;
		name.nameType = nameType;
		for (AnalyzedWord word : listAnalyzedWords) {
			name.listAnalyzedWords.add(word.copy());
		}
		return name;
	}
}
