package com.travel.daily.pic;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.repository.NativeRepository;
import com.travel.utils.FileUtils;




@Component
public class StatTempJob{
	public static final Log LOG = LogFactory.getLog(StatTempJob.class);
	
	
	@Autowired
	private NativeRepository nativeRepository;
	
	private void run(){
		List<String> ids = FileUtils.readLinesFromFile("ids.txt");
		
		ids.parallelStream().forEach(new Consumer<String>(){

			public void accept(String id) {
				// TODO Auto-generated method stub
				run2(id);
			}
			
		});
	}
	
	private void run2(String id){
		//获取 来源
		String source = "";
		// get raw_id
		String raw_id = "";
		String name = "";
		String sqlForRawId = "select raw_id from pic_info where id="+id;
		List<String> rawIds =  nativeRepository.queryStringResult(sqlForRawId);
		if(rawIds.size() > 0) {
			
			raw_id = rawIds.get(0);
			String sqlForSource = "select IdInfo_strSource from raw_data where id="+raw_id;
			List<String> sources = nativeRepository.queryStringResult(sqlForSource);
			if(sources.size() > 0){
				source = sources.get(0);
			}
		
		}

		//获取 url 
		String url = "";
		
		String sqlForGetUrl = "select url,name from pic_info where id="+id;
		List<Object[]> urls = nativeRepository.query(sqlForGetUrl);
		if(urls.size() > 0) {
			Object[] objs = urls.get(0);
			url = objs[0].toString();
			name = objs[1].toString();
		}
		
		LOG.info("flag\t"+id.trim() +"\t"+source.trim()+"\t"+url.trim()+"\t"+name.trim());
	}
	
	
	
	
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				   "classpath:applicationContext.xml");
		StatTempJob job = ac.getBean(StatTempJob.class);
		job.run();
	}
}