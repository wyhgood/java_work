package com.travel.data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

import dataStruct.Pair;
import util.CommUtils;
import util.ObjectUtil;

public abstract class FragmentBase
{

	public String toString()
	{
		// TODO Auto-generated method stub
		return ObjectUtil.getObjectAsString(this);
		// return this.ToDataBaseItem().toString();
	}

	private boolean isStringHashMap(HashMap map)
	{

		try
		{
			HashMap<String, String> cast = (HashMap<String, String>) map;
			return true;
		} catch (Exception e)
		{
			// TODO: handle exception
		}

		return false;

	}

	private boolean isStringLinkedList(String strName)
	{

		if (strName.compareTo("java.util.LinkedList<java.lang.String>") == 0)
			return true;

		return false;

	}

	// 将数据转换成map数据，如果是list和hashmap等container数据，则转化为json
	public HashMap<String, String> ToDataBaseItem()
	{

		HashMap<String, String> mapReturn = new HashMap<String, String>();
		Field[] fields = this.getClass().getFields();

		for (Field field : fields)
		{
			try
			{
				String strFiedName = this.getClass().getSimpleName() + "_" + field.getName();
				
				if(field.get(this)==null){
					mapReturn.put(strFiedName, "");
					continue;
				}
				
				if (field.get(this) instanceof String)
				{
					String strValue = (String) field.get(this);
					mapReturn.put(strFiedName, strValue);
					continue;
				} else if (field.get(this) instanceof HashMap)
				{

					if (isStringHashMap((HashMap) field.get(this)))
					{
						

						mapReturn.put(strFiedName, CommUtils.map2String((HashMap<String, String>) field.get(this),
								Consts.L1_SEPERATOR, Consts.L2_SEPERATOR));
						continue;
					}

				} else if (field.get(this) instanceof LinkedList)
				{

					if (isStringLinkedList(field.getGenericType().toString()))
					{

						mapReturn.put(strFiedName,
								CommUtils.list2String((LinkedList<String>) field.get(this), Consts.L1_SEPERATOR));
						continue;
					}
				}

				// 对于复杂结构直接封装成json数据
				String strJson = JsonWriter.objectToJson(field.get(this));

				mapReturn.put(strFiedName, strJson);
			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return mapReturn;

	}

	// 从json数据转化回来
	public void FromDataBase(HashMap<String, String> mapInput)
	{
		Field[] fields = this.getClass().getFields();

		for (Field field : fields)
		{
			try
			{
				String strFiedName = this.getClass().getSimpleName() + "_" + field.getName();

				String strFieldValue = mapInput.get(strFiedName);

				if (strFieldValue == null)
					continue;

				if (field.getType().newInstance() instanceof String)
				{
					field.set(this, strFieldValue);
					continue;
				} else if (field.getType().newInstance() instanceof HashMap)
				{
					if (isStringHashMap((HashMap) field.getType().newInstance()))
					{

						HashMap<String, String> map = new HashMap<String, String>();
						CommUtils.string2Map(strFieldValue, Consts.L1_SEPERATOR, Consts.L2_SEPERATOR, map);

						field.set(this, map);

						continue;
					}

				} else if (field.getType().newInstance() instanceof LinkedList)
				{

					if (isStringLinkedList(field.getGenericType().toString()))
					{

						LinkedList<String> list = new LinkedList<String>();
						CommUtils.string2List(strFieldValue, Consts.L1_SEPERATOR, list);
						field.set(this, list);
						continue;
					}
				}

				// 对于复杂结构直接封装成json数据

				// System.out.println(strFieldValue);
				Object obj = null;
				if(strFieldValue.trim().length()>0)
				{
					obj= JsonReader.jsonToJava(strFieldValue);
				}
				else {
					obj = field.getType().newInstance();
				}
				field.set(this, obj);

			} catch (Exception e)
			{
				// TODO: handle exception

				System.err.println("error when processing " + field.getName());
				e.printStackTrace();
			}
		}

	}

	// 获取创建database的时候需要创建的字段，全部为string或这text
	public LinkedList<Pair<String>> GetInitSqlField()
	{
		LinkedList<Pair<String>> listReturn = new LinkedList<Pair<String>>();
		Field[] fields = this.getClass().getFields();

		for (Field field : fields)
		{

			String strFieldName = this.getClass().getSimpleName() + "_" + field.getName();
			listReturn.add(new Pair<String>(strFieldName, "text"));
		}

		return listReturn;
	}
}
