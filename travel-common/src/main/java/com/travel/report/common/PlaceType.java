package com.travel.report.common;

public enum PlaceType {
	jingdian(1),
	canyin(2),
	gouwu(3),
	yule(4),
	jiudian(5),
	service(6);
	public int id;
	//餐饮，购物，娱乐，酒店，公共服务
	PlaceType(int i){
		this.id = i;
	}
	static public String getById(int id){
		PlaceType[]  types = PlaceType.values();
		for(PlaceType type:types){
			if(type.id == id){
				return type.name();
			}
		}
		return "";
	}
	static public PlaceType getPlaceType(int id){
		PlaceType[]  types = PlaceType.values();
		for(PlaceType type:types){
			if(type.id == id){
				return type;
			}
		}
		return PlaceType.jingdian;
	}
	public static void main(String args[]){
		System.out.println(PlaceType.jiudian.toString());
	}
}
