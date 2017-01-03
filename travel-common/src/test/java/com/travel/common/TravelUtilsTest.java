package com.travel.common;


import org.junit.Assert;
import org.junit.Test;

import com.travel.utils.TravelUtils;

public class TravelUtilsTest {

	@Test
	public void testSentenceLen(){
		String val = "you can find this mart every where,";
		int len = TravelUtils.sentenceSize(val);
		Assert.assertEquals(len, 7);
	}
	@Test
	public void testReplaceStr(){
		String val = "除了各种冰淇淋 店里还有意面等晚餐 另外还有超级新鲜的牛奶附送 上3.52高分";
		Assert.assertEquals(val.length(), 39);
		val = TravelUtils.replaceStrVal(val);
		Assert.assertEquals(val.length(), 36);
	}
}
