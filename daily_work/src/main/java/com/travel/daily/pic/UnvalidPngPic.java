package com.travel.daily.pic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.repository.NativeRepository;

@Component
public class UnvalidPngPic{
	private static final Log log = LogFactory.getLog(UnvalidPngPic.class);
	
	@Autowired
	private NativeRepository nativeRepository;
	
    private AtomicInteger atomicInteger = new AtomicInteger();
	//记录为主图的png的数量
    private AtomicInteger atomicIntegerMain = new AtomicInteger();
	
	private final void run(){
		// extract id from pic_info 
	    List<Integer> ids = new ArrayList<Integer>();
		for(int i=138647629; i<=1420047629; i++){
		    ids.add(i);
		}
		//String sql = "select id from pic_info where valid=0";
		//ids = nativeRepository.queryIntResult(sql);
		log.info("total size is \t"+ids.size());
		int start = 0;
		int end = 0;
		int step = 100000;
		int size = ids.size();
		while(start < size){
			end = start + step;
			if(end > size) end = size-1;
			log.info("current progress: "+start+"/"+size);
			log.info("current data: png sum "+atomicInteger+"    png main "+atomicIntegerMain);
			List<Integer> subIds = ids.subList(start, end);
			subIds.parallelStream().forEach(new Consumer<Integer>(){
	
				public void accept(Integer id) {
					// TODO Auto-generated method stub
					String extractSql = "select name, source from pic_info where valid=0 and id="+id;
					List<Object[]> objs = nativeRepository.query(extractSql);
					if(objs.size() > 0){
						Object[] obs = objs.get(0);
						if(obs.length == 2){
							String name = obs[0].toString();
							String source = obs[1].toString();
							if(name.contains("png")){
								
								atomicInteger.incrementAndGet();
								if(source.trim().equals("1")){
//									String updateSql = "update pic_info set valid=20 where id="+id+" and name='"+name+"'";
//									nativeRepository.update(updateSql);
//									atomicIntegerMain.incrementAndGet();
									
									log.info("id is: "+id);
								}else{
//									String updateSql = "update pic_info set valid=21 where id="+id+" and name='"+name+"'";
//									nativeRepository.update(updateSql);
									
									log.info("id is: "+id);
								}
							}
						}
					}
					
				}
				
			});
			start += step;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				   "classpath:applicationContext.xml");
		
		UnvalidPngPic job = ac.getBean(UnvalidPngPic.class);
		job.run();
		
	}
	
}