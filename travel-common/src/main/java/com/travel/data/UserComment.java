package com.travel.data;

import java.util.LinkedList;

import util.CommUtils;

public class UserComment extends FragmentBase
{

	public String strCommentId  = "";
	public String strUserPic= "";
	public String strUserName = "";
	public String strUserMark = "";
	public String strUserText = "";
	public String strUserTitle = "";
	public String strCommentTime= "";
	public String strCommentProdScore = "";
	public String strCommentEnvriomentScore = "";
	public String strCommentServiceScore = "";	
	public LinkedList<String> listCommentPics = new LinkedList<String>();
	
	@Override
	public String toString()
	{
		return CommUtils.GetObjectString(this);
		
	}

	public String getStrCommentId() {
		return strCommentId;
	}

	public void setStrCommentId(String strCommentId) {
		this.strCommentId = strCommentId;
	}

	public String getStrUserPic() {
		return strUserPic;
	}

	public void setStrUserPic(String strUserPic) {
		this.strUserPic = strUserPic;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrUserMark() {
		return strUserMark;
	}

	public void setStrUserMark(String strUserMark) {
		this.strUserMark = strUserMark;
	}

	public String getStrUserText() {
		return strUserText;
	}

	public void setStrUserText(String strUserText) {
		this.strUserText = strUserText;
	}

	public String getStrUserTitle() {
		return strUserTitle;
	}

	public void setStrUserTitle(String strUserTitle) {
		this.strUserTitle = strUserTitle;
	}

	public String getStrCommentTime() {
		return strCommentTime;
	}

	public void setStrCommentTime(String strCommentTime) {
		this.strCommentTime = strCommentTime;
	}

	public String getStrCommentProdScore() {
		return strCommentProdScore;
	}

	public void setStrCommentProdScore(String strCommentProdScore) {
		this.strCommentProdScore = strCommentProdScore;
	}

	public String getStrCommentEnvriomentScore() {
		return strCommentEnvriomentScore;
	}

	public void setStrCommentEnvriomentScore(String strCommentEnvriomentScore) {
		this.strCommentEnvriomentScore = strCommentEnvriomentScore;
	}

	public String getStrCommentServiceScore() {
		return strCommentServiceScore;
	}

	public void setStrCommentServiceScore(String strCommentServiceScore) {
		this.strCommentServiceScore = strCommentServiceScore;
	}

	public LinkedList<String> getListCommentPics() {
		return listCommentPics;
	}

	public void setListCommentPics(LinkedList<String> listCommentPics) {
		this.listCommentPics = listCommentPics;
	}
	
	
	
	
	
	
	
	
	
	
	
}
