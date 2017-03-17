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

import com.travel.bak.repository.bak.NativeBakRepository;
import com.travel.repository.NativeRepository;


@Component
public class SynPicSource implements InitializingBean {
	static public final Log log = LogFactory.getLog(SynPicSource.class);
	
	private List<Integer> ids;
	
	@Autowired
	private NativeBakRepository nativeBakRepository;
	
	@Autowired
	private NativeRepository nativeRepository;
	
	private void run(){
		log.info("begining-------");
		
		int start = 0;
		int end = 0;
		int size = ids.size();
		int batch = 100000;
		
		while(start < size){
			end = start+batch;
			if(end > size) end = size;
			log.info("process progress:"+end+"/"+size);
			List<Integer> subIds = ids.subList(start, end);
			subIds.parallelStream().forEach(new Consumer<Integer>(){

				public void accept(Integer id) {
					try{
						// TODO Auto-generated method stub
						// read picture src from other  to get source
						String sql = "select name from pic_info where id="+id;
						List<String> names = nativeRepository.queryStringResult(sql);
						String name = "";
						if(names.size()>0){
							name = names.get(0).trim();
							
						}
						
						String sql2 = "select src from place_info_picture where picture='"+name+"'";
						List<?> srcs = nativeBakRepository.queryIntResult(sql2);
						
//						if(objs == null) return;
						String source = "";
//						log.info("objs[0]:"+objs[0]);
//						if(objs.length > 0){
//							log.info("objs[0]:"+objs[0]);
//							source = objs[0].toString();
//						}
						
						
						if(srcs.size()>0){
							byte b = (byte)((Byte)srcs.get(0));
							source = String.valueOf(b);
						}
						
						log.info("source:"+source+" id:"+id);
						if(!source.equals("")){
							int s;
							
							s = Integer.valueOf(source);
							
							String updateSql = "update pic_info set source="+s+" where id="+id;
							nativeRepository.update(updateSql);
							
							log.info("successfully update id="+id+" source="+source);
						}
						
					}catch(Exception e){
						log.error(e);
						return;
					}
				}
				
				
			});
			start += batch;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"classpath:applicationContext.xml");
		SynPicSource job = ac.getBean(SynPicSource.class);
		job.run();
	}



	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
//		String sql = "select id from pic_info where source<=0";
//		ids = nativeRepository.queryIntResult(sql);
//		log.info("ids size is:"+ids.size());
	}
}