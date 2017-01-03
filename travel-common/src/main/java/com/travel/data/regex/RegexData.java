package com.travel.data.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.travel.utils.TravelUtils;

public class RegexData {

	private String regex;
	private String input;
	private String comment;
	private List<String> defaultValue;
	private List<Integer> groupNumber;
	private List<String> groupResult;
	public RegexData(){
		groupNumber = new LinkedList<Integer>();
	}
	public RegexData(String regex){
		groupNumber = new LinkedList<Integer>();
		this.regex = regex;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public List<String> getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(List<String> defaultValue) {
		this.defaultValue = defaultValue;
	}
	public List<Integer> getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber.add(groupNumber);
	}
	public List<String> getGroupResult() {
		return groupResult;
	}
	public void setGroupResult(List<String> groupResult) {
		this.groupResult = groupResult;
	}
	public boolean run(){
		if(TravelUtils.isEmpty(input))return false;
		groupResult = new LinkedList<String>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()){
			if(groupNumber.isEmpty()){
				groupResult.addAll(defaultValue);
			}else{
				for(int i=0,len=groupNumber.size();i<len;i++){
					groupResult.add(matcher.group(groupNumber.get(i)));
				}
			}
			return true;
		}
		return false;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
