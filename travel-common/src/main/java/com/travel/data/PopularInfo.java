package com.travel.data;

import java.util.LinkedList;



public class PopularInfo extends FragmentBase
{
	public String strProductScore = "";
	public String strEnviromentScore = "";
	public String strServiceScore = "";
	
	public String strScore	= "";
	public String	strRateCount	=	"";
	
	public LinkedList<UserComment> listUserComment = new LinkedList<UserComment>();
	public LinkedList<String> listTags = new LinkedList<String>();


	
	
	
	public boolean SetScore(String strScore)
	{
		try
		{
			double dScore= Double.parseDouble(strScore);
			this.strScore = strScore;
			return true;
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean SetRateCount(String strCount)
	{
		try
		{
			int iRateCount = Integer.parseInt(strCount);
			strRateCount = strCount;
			return true;
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
}
