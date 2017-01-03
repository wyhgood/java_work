package com.travel.common.statistic;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.common.RandomUtils;
import com.travel.data.DoublePair;
import com.travel.utils.TravelUtils;
/**
 * 按概率获取
 */
@Component
public class ProbilityDistribution {
	@Autowired
	private RandomUtils random;
	public DoublePair randomByFreq(List<DoublePair> pairs){
		List<DoublePair> distChain = new LinkedList<DoublePair>();
		int bound = 0;
		for(DoublePair p:pairs){
			if(TravelUtils.isEmpty(p.key))continue;
			int c = (int)p.getValue();
			bound+=c;
			for(int i=0;i<c;i++){
				distChain.add(p);
			}
		}
		int r = random.randomInt(bound);
		return distChain.get(r);
	}
}
