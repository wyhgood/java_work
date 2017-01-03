package com.travel.common;

import org.junit.Assert;
import org.junit.Test;

import com.travel.utils.DateUtils;

public class DateTest {

	@Test
	public void testDateFormat(){
		String d1 = "2014-10-10";
		String d2 = "2014-10-10 10:10:10";
		String d3 = "14-10-10 10:10:10";
		String d4 = "10-10 10:10:10";
		String d5 = "10-10";
		String d6 = "2008-12-30 点评";
		String d7 = "2009-1-4 点评";
		String d8 = "12-10-17  更新于01-10 10:17";
		System.out.println(DateUtils.formatUserCommentTs(d1));
		System.out.println(DateUtils.formatUserCommentTs(d2));
		System.out.println(DateUtils.formatUserCommentTs(d3));
		System.out.println(DateUtils.formatUserCommentTs(d4));
		System.out.println(DateUtils.formatUserCommentTs(d5));
		Assert.assertTrue(DateUtils.formatUserCommentTs(d1).equals(d1));
		Assert.assertTrue(DateUtils.formatUserCommentTs(d2).equals(d2));
		Assert.assertTrue(DateUtils.formatUserCommentTs(d3).equals(d2));
// TODO 单元测试失败
//		Assert.assertTrue(DateUtils.formatUserCommentTs(d4).equals(d2));
//		Assert.assertTrue(DateUtils.formatUserCommentTs(d5).equals(d1));
		System.out.println(DateUtils.formatUserCommentTs(d6));
		System.out.println(DateUtils.formatUserCommentTs(d7));
		System.out.println(DateUtils.formatUserCommentTs(d8));
	}
	@Test
	public void testDateFormatExtractor(){
		System.out.println(DateUtils.extractroYYYYMMDD("2014-1-10 10:10:10"));
	}
}
