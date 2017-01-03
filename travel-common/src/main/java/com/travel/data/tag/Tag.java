package com.travel.data.tag;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class Tag {
	private String o;
	private String a;
	private int s;
	private int e;
	//0:brand 1:pos -1:neg
	private int f;
	public String getO() {
		return o;
	}
	public void setO(String originTag) {
		this.o = originTag;
	}
	public String getA() {
		return a;
	}
	public void setA(String absTag) {
		this.a = absTag;
	}
	public int getS() {
		return s;
	}
	public void setS(int startIdx) {
		this.s = startIdx;
	}
	public int getE() {
		return e;
	}
	public void setE(int endIdx) {
		this.e = endIdx;
	}
	public int getF() {
		return f;
	}
	public void setF(int flag) {
		this.f = flag;
	}
	public static void main(String args[]){
		List<Tag> tags = new ArrayList<Tag>();
		Tag tag = new Tag();
		tag.setA("口味不错");
		tag.setS(2);
		tag.setE(3);
		tag.setO("口味好吃");
		tags.add(tag);
		tag = new Tag();
		tag.setA("风景不错");
		tag.setS(2);
		tag.setE(3);
		tag.setO("风景可以");
		tags.add(tag);
		System.out.println(JSONArray.fromObject(tags).toString());
	}
}
