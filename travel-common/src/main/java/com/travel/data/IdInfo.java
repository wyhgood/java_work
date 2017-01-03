package com.travel.data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;

import dataStruct.Pair;

public class IdInfo extends FragmentBase
{
	public String strSource = "";
	public String strId= "";
	public String strURL = "";
	public String strCity = "";
	public String strCountry= "";
	public String strPlaceType ="";
	
	@Override
	public LinkedList<Pair<String>> GetInitSqlField()
	{
		LinkedList<Pair<String>> listReturn = new LinkedList<Pair<String>>();
		Field[] fields = this.getClass().getFields();

		for (Field field : fields)
		{

			String strFieldName = this.getClass().getSimpleName() + "_" + field.getName();
			listReturn.add(new Pair<String>(strFieldName, "varchar(300)"));
		}
		

		return listReturn;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
