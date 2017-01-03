package com.travel.common;

import org.junit.Test;

import com.travel.entity.RawData;
import com.travel.utils.CloneUtils;

public class CloneUtilsTest {

	@Test
	public void testClone(){
		RawData rd = new RawData();
		rd.setId(1);
		System.out.println(rd.toString());
		RawData rdCopy = (RawData)CloneUtils.deepClone(rd);
		rd.setId(2);
		System.out.println(rd.toString());
		System.out.println(rdCopy.toString());
	}
}
