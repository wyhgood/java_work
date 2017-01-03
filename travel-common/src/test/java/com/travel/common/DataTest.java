package com.travel.common;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import util.EmojiFilter;

import com.travel.utils.TravelUtils;

public class DataTest {

	@Test
	public void testRound(){
		BigDecimal b = new BigDecimal("2.124564").setScale(2, BigDecimal.ROUND_HALF_UP);
		Assert.assertTrue(b.doubleValue()==2.12);
	}
	@Test
	public void testDivider(){
		Assert.assertTrue(TravelUtils.divide(0., 0.)==0);
		Assert.assertTrue(TravelUtils.divide(0., 1.)==0);
		Assert.assertTrue(TravelUtils.divide(1., 0.)==0);
		Assert.assertTrue(TravelUtils.divide(1., 1.)==1);
		Assert.assertTrue(TravelUtils.divide(2., 1.)==2);
		
	}
	@Test
	public void testFilter(){
		System.out.println(EmojiFilter.filterEmoji("\\xF0\\x9F\\x8C\\xB2"));
	}
	
	@Test
	public void testExtract(){
		String sentence = "this a good place";
		System.out.println(TravelUtils.extractTermSet(sentence));
		String regex = "\\splace$";
		
		System.out.println(sentence.replaceAll(regex," "));
	}
}
