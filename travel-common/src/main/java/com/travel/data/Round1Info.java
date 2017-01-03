package com.travel.data;

import java.util.LinkedList;

import com.google.gson.Gson;

public class Round1Info extends FragmentBase
{
	public LinkedList<AnalyzedName> listNames = new LinkedList<AnalyzedName>();
	public LinkedList<String> listBranchNames = new LinkedList<String>();
	
	public LinkedList<String> listBadTel = new LinkedList<String>();
	public LinkedList<String> listAddressSignature = new LinkedList<String>();
	
	public String strChainShopCount = "";
	public String strShadowPoi = "";	
	public String strChainCluster = "";
	public String extraInfo = new Gson().toJson(new Round1InfoExtraInfo());
	
	public void clear()
	{
		listNames.clear();
		listBranchNames.clear();
		listBranchNames.clear();
		listBadTel.clear();
		strChainShopCount = "";
		strShadowPoi = "";
		extraInfo = new Gson().toJson(new Round1InfoExtraInfo());
		listAddressSignature.clear();
	}
}
