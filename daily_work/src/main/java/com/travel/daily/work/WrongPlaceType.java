package com.travel.daily.work;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.repository.NativeRepository;

/*
 * 找出热门的，疑似分类不正确的poi
 *    映射关系
 *    找出热门的  
 * 
 */

@Component
public class WrongPlaceType{
	
	
	
	@Autowired
	private NativeRepository nativeRepository;
	
	private void initDict(){
		
	}
	
	
	private void run(){
		String sql = "select id from raw_data where IdInfo_strPlaceType='jingdian' and PopularInfo_strRateCount>100";
		List<Integer> ids = nativeRepository.queryIntResult(sql);
		
		//分批
		int start = 0;
		int end = 0;
		int batch = 50000;
		
		while(start <ids.size()){
			end = start + batch;
			if(end > ids.size()) end = ids.size();
			List<Integer> subIds = ids.subList(start, end);
			subIds.parallelStream().forEach(new Consumer<Integer>(){

				public void accept(Integer id) {
					// TODO Auto-generated method stub
					String sql2 = "select PlaceInfo_strName, PlaceInfo_listAliasName,IdInfo_strPlaceType from raw_data where id="+id;
					List<Object[]> objss = nativeRepository.query(sql2);
					for(Object[] objs:objss){
						if(objs.length == 3){
						//String name = objs[0].toString();
							String placeInfoStrName = objs[0].toString();
							String placeInfoListAliasName = objs[1].toString();
							String placeType = objs[2].toString();
							
							String possibleType = getPossibleType(placeInfoStrName, placeInfoListAliasName);
							
							
							
							
							
						}
						
					}
				}
				
			});
		}
		
	}
	
	private String getPossibleType(String placeInfoStrName, String placeInfoListAliasName){
		
		
		
		return "";
	}
	
	
	public static void main(String[] args){
		ApplicationContext job = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		WrongPlaceType wpt = job.getBean(WrongPlaceType.class);
		wpt.run();
	}
}