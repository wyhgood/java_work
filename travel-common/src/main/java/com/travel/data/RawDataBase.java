package com.travel.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.CommUtils;
import util.LanguageUtil;
import util.Md5Util;
import dataStruct.Pair;

public class RawDataBase
{
	// public enum PlaceType{
	// unset,canyin,jingdian,gouwu
	// }

	Integer id;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void Init(String strPlaceType)
	{
		// String type = PlaceType.unset;

		if (strPlaceType.compareTo("canyin") == 0)
		{
			// type = PlaceType.canyin;
			restaurantInfo = new RestaurantInfo();
		} else if (strPlaceType.compareTo("jingdian") == 0)
		{
			// type = PlaceType.jingdian;
			viewInfo = new ViewInfo();
		} else if (strPlaceType.compareTo("gouwu") == 0)
		{
			// type = PlaceType.gouwu;
			mallInfo = new MallInfo();
		} else if (strPlaceType.compareTo("jiudian") == 0)
		{
			hotelInfo = new HotelInfo();
		} else if("yule".equals(strPlaceType)){
			viewInfo = new ViewInfo();
		}
		this.idInfo.strPlaceType = strPlaceType;

	}
	public static void test()
	{
		System.out.println("Test");
	}

	// 共用属性

	public IdInfo idInfo = new IdInfo();
	public PlaceInfo placeInfo = new PlaceInfo();
	public PopularInfo popularInfo = new PopularInfo();

	public RestaurantInfo restaurantInfo = null;
	public ViewInfo viewInfo = null;
	public MallInfo mallInfo = null;
	public HotelInfo hotelInfo = null;
	public ScoreInfo scoreInfo = new ScoreInfo();
	
	public Round1Info round1Info = new Round1Info();
	
	public int status;
	
	public Map<String, Integer> unChange = new HashMap<String, Integer>();

	public HashMap<String, String> ToDataBaseItem()
	{
		HashMap<String, String> mapReturn = new HashMap<String, String>();
		mapReturn.putAll(idInfo.ToDataBaseItem());
		mapReturn.putAll(placeInfo.ToDataBaseItem());
		mapReturn.putAll(popularInfo.ToDataBaseItem());
		mapReturn.putAll(round1Info.ToDataBaseItem());

		// id =Integer.parseInt(mapReturn.get("id"));
		if (restaurantInfo != null)
		{
			mapReturn.putAll(restaurantInfo.ToDataBaseItem());
		}else{
			mapReturn.putAll(new RestaurantInfo().ToDataBaseItem());
		}
		if (viewInfo != null)
		{
			mapReturn.putAll(viewInfo.ToDataBaseItem());
		}else{
			mapReturn.putAll(new ViewInfo().ToDataBaseItem());
		}
		if (mallInfo != null)
		{
			mapReturn.putAll(mallInfo.ToDataBaseItem());
		}else{
			mapReturn.putAll(new MallInfo().ToDataBaseItem());
		}
		if (hotelInfo != null)
		{
			mapReturn.putAll(hotelInfo.ToDataBaseItem());
		}else{
			mapReturn.putAll(new HotelInfo().ToDataBaseItem());
		}

		return mapReturn;

	}
	public HashMap<String, String> ToDataBaseItemWithoutR1()
	{
		HashMap<String, String> mapReturn = new HashMap<String, String>();
		mapReturn.putAll(idInfo.ToDataBaseItem());
		mapReturn.putAll(placeInfo.ToDataBaseItem());
		mapReturn.putAll(popularInfo.ToDataBaseItem());

		// id =Integer.parseInt(mapReturn.get("id"));
		if (restaurantInfo != null)
		{
			mapReturn.putAll(restaurantInfo.ToDataBaseItem());
		}
		if (viewInfo != null)
		{
			mapReturn.putAll(viewInfo.ToDataBaseItem());
		}
		if (mallInfo != null)
		{
			mapReturn.putAll(mallInfo.ToDataBaseItem());
		}
		if (hotelInfo != null)
		{
			mapReturn.putAll(hotelInfo.ToDataBaseItem());
		}

		return mapReturn;

	}

	public void FromDataBase(HashMap<String, String> inputMap)
	{
		this.id = Integer.parseInt(inputMap.get("id"));
		this.status = Integer.parseInt(inputMap.get("status"));
		
		String strUnChange = inputMap.get("unchanged");
		if(strUnChange!=null)
		{
			
			try
			{
				JSONObject jsonObject = JSONObject.fromObject(strUnChange);
				
				for(Object key:jsonObject.keySet())
				{
					String strKey = key.toString();
					Integer iValue = jsonObject.getInt(strKey);
					
					unChange.put(strKey, iValue);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}

		idInfo = new IdInfo();
		idInfo.FromDataBase(inputMap);
		placeInfo.FromDataBase(inputMap);
		popularInfo.FromDataBase(inputMap);
		round1Info.FromDataBase(inputMap);

		if (idInfo.strPlaceType.compareTo("canyin") == 0)
		{
			// type = PlaceType.canyin;
			restaurantInfo = new RestaurantInfo();
			restaurantInfo.FromDataBase(inputMap);
		} else if (idInfo.strPlaceType.compareTo("jingdian") == 0)
		{
			// type = PlaceType.jingdian;
			viewInfo = new ViewInfo();
			viewInfo.FromDataBase(inputMap);
		} else if (idInfo.strPlaceType.compareTo("gouwu") == 0)
		{
			// type = PlaceType.gouwu;
			mallInfo = new MallInfo();
			mallInfo.FromDataBase(inputMap);
		} else if (idInfo.strPlaceType.compareTo("jiudian") == 0)
		{
			// type = PlaceType.gouwu;
			hotelInfo = new HotelInfo();
			hotelInfo.FromDataBase(inputMap);
		}

	}

	public static  LinkedList<Pair<String>> GetSqlInitField()
	{
		IdInfo idInfo = new IdInfo();
		PopularInfo popularInfo = new PopularInfo();
		RestaurantInfo restaurantInfo = new RestaurantInfo();
		ViewInfo viewInfo = new ViewInfo();
		MallInfo mallInfo = new MallInfo();
		PlaceInfo placeInfo = new PlaceInfo();
		HotelInfo hotelInfo = new HotelInfo();
		Round1Info round1Info = new Round1Info();

		LinkedList<Pair<String>> listReturn = new LinkedList<Pair<String>>();
		listReturn.add(new Pair("update_status", "varchar(100) NOT NULL default '0'"));
		listReturn.addAll(idInfo.GetInitSqlField());
		listReturn.addAll(placeInfo.GetInitSqlField());
		listReturn.addAll(popularInfo.GetInitSqlField());
		listReturn.addAll(restaurantInfo.GetInitSqlField());
		listReturn.addAll(mallInfo.GetInitSqlField());
		listReturn.addAll(viewInfo.GetInitSqlField());
		listReturn.addAll(hotelInfo.GetInitSqlField());
		listReturn.addAll(round1Info.GetInitSqlField());

		return listReturn;
	}

	public static boolean IsUselessPic(String strPic)
	{
		if (strPic.contains("nipic") && strPic.contains("mafengwo"))
			return true;
		if (strPic.contains("no-photo"))
			return true;

		return false;
	}

	public JSONArray ListToJsonArray(List inputList)
	{
		JSONArray jsonArray = new JSONArray();
		for (Object object : inputList)
		{
			jsonArray.add(object);
		}
		return jsonArray;
	}

	public LinkedList<String> getAllDownloadPics()
	{
		LinkedList<String> listReturn = new LinkedList<String>();

		listReturn.add(placeInfo.strMainPic+"\t"+"main_pic");

		for(String strPerListPic:placeInfo.listPics)
		{
			listReturn.add(strPerListPic+"\t"+"list_pic");
		}
		

		if (restaurantInfo != null)
		{
			for (int i = 0; i < restaurantInfo.listFoodWithPic.size(); i++)
			{
				
				listReturn.add(restaurantInfo.listFoodWithPic.get(i).p2+"\t"+"food_with_pic");

			}
		}

		for (int i = 0; i < popularInfo.listUserComment.size(); i++)
		{
			UserComment userComment = popularInfo.listUserComment.get(i);
			for (int iCommentIndex = 0; iCommentIndex < userComment.listCommentPics.size(); iCommentIndex++)
			{
				listReturn.add(userComment.listCommentPics.get(iCommentIndex)+"\t"+"user_comment");
			}
		}
		return listReturn;
	}
	public LinkedList<String> getCommentHeadPics()
	{
		LinkedList<String> listReturn = new LinkedList<String>();

		
		for (int i = 0; i < popularInfo.listUserComment.size(); i++)
		{
			UserComment userComment = popularInfo.listUserComment.get(i);
			for (int iCommentIndex = 0; iCommentIndex < userComment.listCommentPics.size(); iCommentIndex++)
			{
				listReturn.add(userComment.strUserPic);
			}
		}
		return listReturn;
	}

	public JSONObject toJson()
	{

		JSONObject wholeObjct = new JSONObject();

		wholeObjct.accumulate("name", placeInfo.strName);
		wholeObjct.accumulate("alias", ListToJsonArray(placeInfo.listAliasName));

		if (restaurantInfo != null)
		{
			wholeObjct.accumulate("foodtype", ListToJsonArray(restaurantInfo.listFoodType));
		}
		wholeObjct.accumulate("areatype", idInfo.strPlaceType);

		wholeObjct.accumulate("desc", placeInfo.strDesc);
		wholeObjct.accumulate("type", idInfo.strPlaceType);
		wholeObjct.accumulate("url", idInfo.strURL);

		wholeObjct.accumulate("telephone", ListToJsonArray(placeInfo.listTelephone));

		if (!IsUselessPic(placeInfo.strMainPic))
		{
			String strMd5 = Md5Util.getMd5(placeInfo.strMainPic);
			wholeObjct.accumulate("pic", strMd5);

		}

		wholeObjct.accumulate("place", idInfo.strCity);
		wholeObjct.accumulate("country", idInfo.strCountry);

		wholeObjct.accumulate("latitude", placeInfo.strLat);
		wholeObjct.accumulate("longitude", placeInfo.strLng);
		wholeObjct.accumulate("address", placeInfo.strAddress);

		// String strPhone = firstRawData.strTel;
		// wholeObjct.accumulate("phone", strPhone);

		wholeObjct.accumulate("travel", placeInfo.strTraffic);

		wholeObjct.accumulate("openinghours", placeInfo.strOpenTime);

		wholeObjct.accumulate("score", popularInfo.strScore);

		wholeObjct.accumulate("scorenum", popularInfo.strRateCount);

		wholeObjct.accumulate("cost", placeInfo.strCost);

		if (mallInfo != null)
		{
			wholeObjct.accumulate("keywords", ListToJsonArray(popularInfo.listTags));
		}

		if (mallInfo != null)
		{
			wholeObjct.accumulate("recommend", ListToJsonArray(mallInfo.listRecommendShop));
		}

		if (restaurantInfo != null)
		{
			wholeObjct.accumulate("recommend", ListToJsonArray(restaurantInfo.listRecommendFood));
		}

		wholeObjct.accumulate("tastescore", popularInfo.strProductScore);
		wholeObjct.accumulate("servicescore", popularInfo.strServiceScore);
		wholeObjct.accumulate("environmentscore", popularInfo.strEnviromentScore);

		if (restaurantInfo != null)
		{
			JSONArray foodAndPicJson = new JSONArray();

			for (int i = 0; i < restaurantInfo.listFoodWithPic.size(); i++)
			{

				Pair<String> perPair = restaurantInfo.listFoodWithPic.get(i);

				JSONObject perJson = new JSONObject();
				perJson.accumulate("name", perPair.p1);

				if (IsUselessPic(perPair.p2))
					continue;

				String strMd5 = Md5Util.getMd5(perPair.p2);
				perJson.accumulate("pic", strMd5);

				foodAndPicJson.add(perJson);

			}
			wholeObjct.accumulate("foodpic", foodAndPicJson);
		}

		JSONArray picsJson = new JSONArray();
		for (int i = 0; i < placeInfo.listPics.size(); i++)
		{

			String strPic = placeInfo.listPics.get(i);

			if (IsUselessPic(strPic))
				continue;

			String strMd5 = Md5Util.getMd5(strPic);
			picsJson.add(strMd5);
		}
		wholeObjct.accumulate("pics", picsJson);

		JSONArray commentJSON = new JSONArray();

		for (int i = 0; i < popularInfo.listUserComment.size(); i++)
		{
			JSONObject jsonPerComment = new JSONObject();

			UserComment userComment = popularInfo.listUserComment.get(i);

			jsonPerComment.accumulate("id", userComment.strCommentId);
			jsonPerComment.accumulate("username", userComment.strUserName);
			jsonPerComment.accumulate("userpic", userComment.strUserPic);
			jsonPerComment.accumulate("score", userComment.strUserMark);
			jsonPerComment.accumulate("prodscore", userComment.strCommentProdScore);
			jsonPerComment.accumulate("servicescore", userComment.strCommentServiceScore);
			jsonPerComment.accumulate("envorimentscore", userComment.strCommentEnvriomentScore);
			jsonPerComment.accumulate("time", userComment.strCommentTime);
			jsonPerComment.accumulate("text", userComment.strUserText);

			JSONArray jsonArrayCommentPics = new JSONArray();
			for (String strCommentPic : userComment.listCommentPics)
			{
				if (!IsUselessPic(strCommentPic))
				{
					String strMd5 = Md5Util.getMd5(strCommentPic);
					jsonArrayCommentPics.add(strMd5);
				}
			}
			jsonPerComment.accumulate("pics", jsonArrayCommentPics);

			commentJSON.add(jsonPerComment);
		}
		wholeObjct.accumulate("comments", commentJSON);

		return wholeObjct;

	}

	// 获取所有名称 把所有名称并在一起返回
	public String GetCompeleteName()
	{
		String strCompleteName = "";
		strCompleteName += placeInfo.strName;

		for (String strAliasName : placeInfo.listAliasName)
		{
			strCompleteName += " " + strAliasName;
		}

		return strCompleteName;
	}
	
	/*
	 * 专门处理中英文混合的case, 找出别名
	 */
	private static List<String> getChAnEnPotentailNames(String strInput)
	{
		
		String[] partsOri = strInput.split("\\s");
		
		ArrayList<String> parts= new ArrayList<String>();
		for (String strPerPart : partsOri)
		{
			if(strPerPart.trim().length()>0)
			{
				String strCleanName = CommUtils.REGEX_find(strPerPart, "([^\\(\\)\\（\\）]*)").get(0);
				parts.add(strCleanName);
			}
		}
		
		if(parts.size()<2) return null;
		
		List<Integer> chIndexes = new ArrayList<Integer>();
		List<Integer> enIndexes = new ArrayList<Integer>();
		
		for(int i=0;i<parts.size();i++)
		{
			String strPerPart = parts.get(i);
			if(LanguageUtil.isOnlyChinese(strPerPart))
			{
				chIndexes.add(i);
			}
			else {
				enIndexes.add(i);
			}
		}
		
		if(chIndexes.size()==0) return null;
		if(enIndexes.size()==0) return null;
		
		if(chIndexes.get(0)+chIndexes.size()-1!=chIndexes.get(chIndexes.size()-1)) return null;
		
		if(enIndexes.get(0)+enIndexes.size()-1!=enIndexes.get(enIndexes.size()-1)) return null;
		
		if(enIndexes.size()<2) return null;
		
		
		List<String> listReturn = new ArrayList<String>();
		StringBuffer chBuffer = new StringBuffer();
		if(chIndexes.contains(0))
		for(int i=0;i<chIndexes.size();i++)
		{
			if(i>0)
			{
				chBuffer.append(" ");
			}
			chBuffer.append(parts.get(chIndexes.get(i)));
			
		}
		
		if(chIndexes.contains(0))
		{
			listReturn.add(chBuffer.toString());
		}
		
		
		StringBuffer enBuffer = new StringBuffer();
		for(int i=0;i<enIndexes.size();i++)
		{
			if(i>0)
			{
				enBuffer.append(" ");
			}
			enBuffer.append(parts.get(enIndexes.get(i)));
			
		}
		if(enIndexes.contains(0))
		{
			listReturn.add(enBuffer.toString());
		}
		
		
		return listReturn;
	}

	private LinkedList<String> getPotentailAliasName(String strName)
	{
		LinkedList<String> listReturn = new LinkedList<String>();
		
		String[] parts = strName.split("(?<![\\(|（].{0,50})/");
		for (String strPerPart : parts)
		{
			listReturn.add(strPerPart.trim());
		}
		
		List<String> listEnAndCnCombieNames = getChAnEnPotentailNames(strName);
		if(listEnAndCnCombieNames!=null)
		{
			listReturn.addAll(listEnAndCnCombieNames);
		}
		return listReturn;
	}
	
	public Set<String> getAllNames()
	{
		HashSet<String> setReturn = new HashSet<String>();
		
		HashSet<String> listAllCandidates = new HashSet<String>();
		
		listAllCandidates.addAll(placeInfo.listAliasName);
		listAllCandidates.add(placeInfo.strName.replace("\u00a0", "").trim());
		setReturn.addAll(getPotentailAliasName(placeInfo.strName.replace("\u00a0", "").trim()));
		
		//setReturn.addAll(getPotentailAliasName(placeInfo.strName.replace("\u00a0", "").trim()));
		
		
		for (String strPerAliasName : listAllCandidates)
		{

			if(strPerAliasName.trim().length()>0)
			{
				setReturn.addAll(getPotentailAliasName(strPerAliasName.trim()));
			}
		}
		
		Set<String> removeSpaceName = new HashSet<String>();
		for(String name : setReturn){
			if(name.matches("[\\s]+")){
				removeSpaceName.add(name.replaceAll("[\\s]+", ""));
			}
		}
		setReturn.addAll(removeSpaceName);
		
		
		return setReturn;
	}
	public static void main(String[] args)
	{
		String strName = "sssssss/sdfsdf/sdfsdf/sffdsfd/Piaget（义安城/高岛屋店)sfsfsdfdsf/sdfsdff";
		LinkedList<String> listReturn = new LinkedList<String>();
		
		//LinkedList<String> listNames = CommUtils.REGEX_find(strName, "[\\(|（]([^\\(\\)\\（\\）]*)[\\)|）]");
		

		String[] parts = strName.split("(?<![\\(|（].{0,50})/");
		for (String strPerPart : parts)
		{
			listReturn.add(strPerPart.trim());
		}
		
		List<String> listEnAndCnCombieNames = getChAnEnPotentailNames(strName);
		if(listEnAndCnCombieNames!=null)
		{
			listReturn.addAll(listEnAndCnCombieNames);
		}
		System.out.println(listReturn);
	}
}
