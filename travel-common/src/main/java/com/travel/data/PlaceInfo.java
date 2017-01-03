package com.travel.data;

import java.util.HashMap;
import java.util.LinkedList;

import dataStruct.Pair;
import util.CommUtils;
import util.ObjectUtil;


public class PlaceInfo extends FragmentBase
{
	public String strLat	=	"";
	public String strLng	=	"";
	
	public String strName	=	"";
	public String strAddress	=	"";

	public String strOpenTime	=	"";
	public String strTraffic	=	"";
	public String strMainPic	= 	"";
	public String strDesc	=	"";
	
	public String strCost	=	"";
	
	public String strLocalName = "";
	
	
	public String strStreetAddress = "";
	public String strExtAddress = "";
	public String strLocality = "";
	public String strCountry = "";
	public String strPostCode = "";
	public String strRegion = "";
	
	
	public String strLocalStreetAddress = "";
	public String strLocalExtAddress = "";
	public String strLocalLocality = "";
	public String strLocalCountry = "";
	public String strLocalPostCode = "";
	public String strLocalRegion = "";
//	public String strChainMainName="";
//	public String strChainBranchName="";
	
	
	
//	alter table raw_data add PlaceInfo_strCountry varchar(200) NOT NULL DEFAULT "";
//	alter table raw_data add PlaceInfo_strPostCode varchar(200) NOT NULL DEFAULT "";
//	alter table raw_data add PlaceInfo_strLocalStreetAddress varchar(200) NOT NULL DEFAULT "";
//	alter table raw_data add PlaceInfo_strLocalExtAddress varchar(200) NOT NULL DEFAULT "";
//	alter table raw_data add PlaceInfo_strLocalLocality  varchar(200) NOT NULL DEFAULT "";
//	alter table raw_data add PlaceInfo_strLocalCountry varchar(200) NOT NULL DEFAULT "";
//	alter table raw_data add PlaceInfo_strLocalPostCode NOT NULL DEFAULT "";

	
	public LinkedList<String> listTelephone	=	new LinkedList<String>();
	public LinkedList<String> listAliasName = new LinkedList<String>();
	public LinkedList<String> listPics = new LinkedList<String>();
	
	
	
	@Override
	public LinkedList<Pair<String>>  GetInitSqlField()
	{
		// TODO Auto-generated method stub
		LinkedList<Pair<String>>  listReturn =  super.GetInitSqlField();
		
		String strClassName = this.getClass().getSimpleName();
		
		for (Pair<String> pair : listReturn)
		{
			if(pair.p1.compareTo(strClassName+"_strName")==0)
			{
				pair.p2 = "varchar(150)";
			}
		}
		
		
		
		return listReturn;
	}

	
	

	
	
	
}
