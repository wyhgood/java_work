package com.travel.daily.work;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.repository.NativeRepository;




/**
 * 
 * @author wyhgood
 * 从raw_data内读取daodao的rawid
 * 逐一从pic_info 匹配图片，将source=2的图片 置为无效  valid = 1
 */
@Component
public class DropDaoDaoPic implements InitializingBean{
	static public final Log log = LogFactory.getLog(DropDaoDaoPic.class);
	
	@Autowired
	private NativeRepository nativeRepository;
	
	
	private List<Integer> rawIds;
	
	
	private void run(){
		int start = 0;
		int end = 0;
		int batch = 100000;
		int size = rawIds.size();
		
		while(start < size){
			end = start + batch;
			if(end > size) end = size;
			log.info("progress\t"+start);
			List<Integer> subIds = rawIds.subList(start, end);
			subIds.parallelStream().forEach(new Consumer<Integer>(){

				public void accept(Integer t) {
					// TODO Auto-generated method stub
					//update pic_info where rawid=? and source=2
					String updateSql = "update pic_info set valid=1 where source=2 and raw_id='"+t+"'";
					nativeRepository.update(updateSql);
					log.info("successfully update "+t);
				}
				
			});
			start = start+batch;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"classpath:applicationContext.xml");
		DropDaoDaoPic job = ac.getBean(DropDaoDaoPic.class);
		job.run();
	}






	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
//		String sql = "select id from raw_data where IdInfo_strSource='daodao'";
//		rawIds = nativeRepository.queryIntResult(sql);
//		log.info("ids size is:"+rawIds.size());
	}	
}