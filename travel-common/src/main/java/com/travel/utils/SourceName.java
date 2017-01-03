package com.travel.utils;

public interface SourceName {

	public static String MFW = "mfw";
	public static String QYER = "qyer";
	public static String DIANPING = "dianping";
	public static String DAODAO = "daodao";
	
	public static String CTRIP = "ctrip";
	public static String BOOKING = "booking";
	public static String AGODA = "agoda";
	public static String HOTELS = "hotels";
	
	public static String FOURSQUARE = "foursquare";
	public static String YELP = "yelp";
	
	public static String[] DIST_SOURCES = new String[]{CTRIP,BOOKING,AGODA,HOTELS};
	public static String[] SOURCES = new String[]{MFW,QYER,DIANPING,DAODAO,FOURSQUARE,YELP,HOTELS};
}
