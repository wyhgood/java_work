package com.travel.common;

import org.junit.Assert;
import org.junit.Test;

import com.travel.utils.TravelUtils;

public class TravelEquals {

	@Test
	public void testEquals(){
//		Assert.assertTrue(TravelUtils.isEquals(null, null));
		Assert.assertTrue(!TravelUtils.isEquals("", null));
		Assert.assertTrue(!TravelUtils.isEquals(null, ""));
		Assert.assertTrue(!TravelUtils.isEquals("a", "b"));
		Assert.assertTrue(TravelUtils.isEquals("a", "a"));
	}
}
