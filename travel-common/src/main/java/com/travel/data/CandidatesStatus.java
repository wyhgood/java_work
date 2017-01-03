package com.travel.data;
public interface CandidatesStatus
{

	/**
	 * not match
	 */
	public static int LEVEL1 = 1;
	/**
	 * can't judge match
	 */
	public static int LEVEL2 = 2;
	/**
	 * match exactly
	 */
	public static int LEVEL3 = 3;
	public static int DEFAULT = LEVEL2;
}
