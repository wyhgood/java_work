package com.travel.data;

public class DoublePair{
	public String key;
	public double value;
	public String debugStr;
	public DoublePair(){}
	public DoublePair(String key,double value){
		this.key = key;
		this.value = value;
	}
	public DoublePair(String key,double value,String debugStr){
		this.key = key;
		this.value = value;
		this.debugStr = debugStr;
	}
	public String getDebugStr() {
		return debugStr;
	}
	public void setDebugStr(String debugStr) {
		this.debugStr = debugStr;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
}