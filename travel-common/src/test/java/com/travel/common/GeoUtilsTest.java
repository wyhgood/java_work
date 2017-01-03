package com.travel.common;

import org.junit.Assert;
import org.junit.Test;

import com.travel.utils.GeoUtil;

public class GeoUtilsTest {

	@Test
	public void testGeoUtil(){
		double dis = GeoUtil.Distance(-71.8562293,45.015865,-79.76214379999999,40.496091);
		System.out.println(dis);
	}
}
