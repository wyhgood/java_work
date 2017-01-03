package com.travel.data;

import java.util.HashMap;
import java.util.LinkedList;

public class MergeResult
{
	public String strMergeId = "";
	public LinkedList<RawDataBase> listRawDataBases = new LinkedList<RawDataBase>();
	
	public LinkedList<String> GetAllNames()
	{
		HashMap<String, String> mapNames = new HashMap<String, String>();
		
		for (RawDataBase rawDataBase : listRawDataBases)
		{
			try{
				
				mapNames.put(rawDataBase.placeInfo.strName, "");
				
				for (String strAliasName : rawDataBase.placeInfo.listAliasName)
				{
					mapNames.put(strAliasName, "");
				}
			}catch(Exception e){
				try
				{
					System.out.println(rawDataBase.placeInfo);
					System.out.println(rawDataBase.placeInfo.strName);
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		LinkedList<String> listNames = new LinkedList<String>();
		
		for (String strKey : mapNames.keySet())
		{
			listNames.add(strKey);
		}
		
		return listNames;
		
	}
	
	public String GetCity()
	{
		return listRawDataBases.get(0).idInfo.strCity;
	}
	

	public String GetCompeleteName()
	{
		LinkedList<String> listNames =GetAllNames();
		String strAllName = "";
		for (String strName : listNames)
		{
			strAllName += " "+strName;
		}
		return strAllName;
	}
	
	public String GetType()
	{
		return listRawDataBases.get(0).idInfo.strPlaceType;
	}
	
	public String GetLat()
	{
		return listRawDataBases.get(0).placeInfo.strLat;
	}
	public String GetLng()
	{
		return listRawDataBases.get(0).placeInfo.strLng;
	}
}


