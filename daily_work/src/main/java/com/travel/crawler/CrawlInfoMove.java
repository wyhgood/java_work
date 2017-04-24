package com.travel.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.bak.repository.bak.CrawlInfoRepository2;
import com.travel.entity.CrawlInfo;
import com.travel.repository.CrawlInfoRepository;

@Component
public class CrawlInfoMove{
	
	@Autowired
	private CrawlInfoRepository crawlInfoRepository;
	@Autowired
	private CrawlInfoRepository2 crawlInfoRepository2;
	
	private void run(){
		List<Long> tasks = getTask();
		tasks.parallelStream().forEach(new Consumer<Long>(){

			public void accept(Long id) {
				// TODO Auto-generated method stub
				CrawlInfo crawlInfo = crawlInfoRepository2.findOne(id);
				if(crawlInfo != null){
					CrawlInfo crawlInfoNew = new CrawlInfo();
					crawlInfoNew.setCrawlConf("");
					crawlInfoNew.setCrawlCount(0);
					crawlInfoNew.setCrawlIndex1(crawlInfo.getCrawlIndex1());
					crawlInfoNew.setCrawlIndex2(crawlInfo.getCrawlIndex2());
					crawlInfoNew.setCrawlIndex3(crawlInfo.getCrawlIndex3());
					crawlInfoNew.setCrawlStatus(crawlInfo.getCrawlStatus());
					crawlInfoNew.setCreateTime(crawlInfo.getCreateTime());
					crawlInfoNew.setMaxCrawlCount(55);
					crawlInfoNew.setPriority(crawlInfo.getPriority());
					crawlInfoNew.setSrc("zomato");
					crawlInfoNew.setUpdateTime(crawlInfo.getUpdateTime());
					crawlInfoRepository.save(crawlInfoNew);
				}
			}
			
		});
	}
	
	
	
	
	
	
	private List<Long> getTask(){
		List<Long> list = new ArrayList<Long>();
		
		for(Long i=0L; i<=303L; i++){
			list.add(i);
		}
		
		return list;
	}
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		CrawlInfoMove job = ac.getBean(CrawlInfoMove.class);
		job.run();
	}
	
	
}