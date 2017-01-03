package com.travel.data;

import net.sf.json.JSONArray;

public class OpenTimeData {

	private int i;
	private String s;
	private String e;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String show(){
		return JSONArray.fromObject(this).toString();
	}
}
