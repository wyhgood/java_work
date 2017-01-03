package com.travel.data;

import java.util.HashMap;
import java.util.Map;

public class HotMergeStatus {
	private static Map<Integer, String> statusMsgMap = new HashMap<Integer, String>();
	static {
		statusMsgMap.put(0, "正常");
		statusMsgMap.put(1, "景点花费时间");
		statusMsgMap.put(2, "购物花费时间");
		statusMsgMap.put(3, "景点开放时间");
		statusMsgMap.put(4, "购物开放时间");
		statusMsgMap.put(5, "Google地图无公共交通");
		statusMsgMap.put(6, "已人工处理");
		statusMsgMap.put(7, "景点无游玩时间");
		statusMsgMap.put(8, "景点游玩时间太长");
		statusMsgMap.put(9, "不确定游玩时间");
	}

	public static final int JINGDIAN_COST_TIME = 1;
	public static final int GOUWU_COST_TIME = 2;
	public static final int JINGDIAN_OPEN_TIME = 3;
	public static final int GOUWU_OPEN_TIME = 4;
	public static final int LAT_LNG = 5;
	public static final int OK = 0;
	public static final int MANNUL_OP = 6;
	public static final int JINGDIAN_COST_TIME_NOT_ENSURE = 9;
	public static final int JINGDIAN_COST_TIME_EMPTY = 7;
	public static final int JINGDIAN_COST_TIME_ALL_DAY = 8;

	public static String getErrMsg(String status) {
		if (status == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		String[] statuses = status.split("\001");
		for (int index = 0; index < statuses.length; index++) {
			if (sb.length() > 0) {
				sb.append("<br/>");
			}
			sb.append(statusMsgMap.get(Integer.parseInt(statuses[index])));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getErrMsg("1\0012"));
	}
}
