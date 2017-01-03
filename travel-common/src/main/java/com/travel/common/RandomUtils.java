package com.travel.common;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class RandomUtils implements InitializingBean{
	Logger log = LoggerFactory.getLogger(RandomUtils.class);
//	private Random random;
	public int randomInt(int bound){
//		if(bound<=0){
//			log.warn("random bound must a possitive number");
//		}
//		return random.nextInt(bound);
		return nextIntCurr(bound);
	}
	
	public boolean probabilityRandom(int percentage){
//		if(random.nextInt(100)<percentage)return true;
		return probablityRandomCurr(percentage);
	}
	/**
	 * between zero (inclusive) and the specified bound (exclusive)
	 * @param bound
	 * @return
	 */
	public int nextIntCurr(int bound){
		if(bound<=0){
			log.warn("random bound must a possitive number");
		}
		return ThreadLocalRandom.current().nextInt(bound);
	}
	public boolean probablityRandomCurr(int percentage){
		if(ThreadLocalRandom.current().nextInt(100)<percentage)return true;
		return false;
	}
	public void afterPropertiesSet() throws Exception {
//		random = new Random();
	}
}
