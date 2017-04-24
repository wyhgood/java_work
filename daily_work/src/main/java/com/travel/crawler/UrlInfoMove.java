package com.travel.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.bak.repository.bak.UrlInfoRepository2;
import com.travel.entity.UrlInfo;
import com.travel.repository.UrlInfoRepository;

@Component
public class UrlInfoMove{
	public static Log log = LogFactory.getLog(UrlInfoMove.class);
	
	
	
	@Autowired
	private UrlInfoRepository urlInfoRepository;
	@Autowired
	private UrlInfoRepository2 urlInfoRepository2;
	
	
	private void run(){
		
		List<Long> tasks = getTask();
		tasks.parallelStream().forEach(new Consumer<Long>(){

			public void accept(Long id) {
				// TODO Auto-generated method stub
				UrlInfo urlInfo = urlInfoRepository2.findOne(id);
				if(urlInfo != null){
					String urlMd5 = urlInfo.getUrlMd5();
					List<UrlInfo> urlInfos = urlInfoRepository.findByUrlMd5(urlMd5);
					if(urlInfos.size() > 0){
						return;
					}
					UrlInfo urlInfoNew = new UrlInfo();
					urlInfoNew.setCrawlCount(0);
					urlInfoNew.setErrCount(0);
					urlInfoNew.setCrawlFeature("");
					urlInfoNew.setHtml("");
					urlInfoNew.setHtmlFeature("");
					urlInfoNew.setRedirectUrl("");
					urlInfoNew.setReferUrl("");
					urlInfoNew.setUpdateTime(urlInfo.getUpdateTime());
					urlInfoNew.setCrawlIndex1(urlInfo.getCrawlIndex1());
					urlInfoNew.setCrawlIndex2(urlInfo.getCrawlIndex2());
					urlInfoNew.setCrawlIndex3(urlInfo.getCrawlIndex3());
					urlInfoNew.setUrl(urlInfo.getUrl());
					urlInfoNew.setCreateTime(urlInfo.getCreateTime());
					urlInfoNew.setHtmlFormat("base64.zlib");
					urlInfoNew.setPageType(urlInfo.getPageType());
					urlInfoNew.setSubPageType("canyin");
					urlInfoNew.setUrlMd5(urlInfo.getUrlMd5());
					urlInfoNew.setSrc(urlInfo.getSrc());
					urlInfoNew.setValid(urlInfo.getValid());
					urlInfoNew.setStatus(urlInfo.getStatus());		
					urlInfoRepository.saveAndFlush(urlInfoNew);
					
				}else{
					log.info("id not found "+id);
				}
			}
		});
	}
	
	
	//task list
	private List<Long> getTask(){
		List<Long> list = new ArrayList<Long>();
		
		for(Long i=850000L; i<=1100000L; i++){
			list.add(i);
		}
		
		return list;
	}
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		UrlInfoMove job = ac.getBean(UrlInfoMove.class);
		job.run();
	}
}