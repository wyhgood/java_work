package com.travel.daily.work;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.repository.MergeIdEntityRepository;
import com.travel.repository.NativeRepository;
import com.travel.utils.ConfigTool;

@Component
public class FakeCommentTime{
	public static final Log log = LogFactory.getLog(FakeCommentTime.class);
	private static final int  countMax = Integer.valueOf(ConfigTool.props.getProperty("rate_count_max", "10000"));
	
	@Autowired
	private NativeRepository nativeRepository;
	@Autowired
	private MergeIdEntityRepository mergeIdEntityRepository;
	
	
	//任务分发
	private List<Long> getTask(){
		List<Long> ids = mergeIdEntityRepository.findAllId();
//		String sql = "select id from merge_id_entity";
//		
//		
//		List<Object[]> objss = nativeRepository.query(sql);
//		for(Object[] objs:objss){
//			if(objs.length > 0){
//				int id = ((BigInteger)objs[0]).intValue();
//				ids.add(id);
//			}
//		}
		return ids;
	}
	
	//过滤
	private boolean isFilter(Long id){
		//update time 
		String updateTime = "";
		int days = 1;
		String sql = "select update_time from fake_comment_time_monitor where merge_id="+id;
		List<String> results = nativeRepository.queryStringResult(sql);
		if(results.size() > 0){
			updateTime = results.get(0);
		}
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    Date parsedDate = dateFormat.parse(updateTime);
		    long t =  new Date().getTime() - parsedDate.getTime();
		    days = (int)t/86400;
		}catch(Exception e){//this generic but you can control another types of exception
			
		}
		
		//有效评论数  计算展示概率 p
		String sql2 = "select count(1) from user_comment where raw_id in(select raw_id from rawid_mergeid_mapping where merge_id='"+id+"') and flag>=0 ";
		int count = 0;
		count = nativeRepository.getCount(sql2);
		
		//获取有效评论数  
		System.out.println("有效评论数 "+ count);
		count = count * days;
		//根据p 和 间隔天数  计算最终概率1-100％
		int p = 0;
		if(count > countMax) {
			p = 100;
		}else if(count <= countMax){
			p = count/100;
			if(p == 0) p = 1;
		}
		
		Random r = new Random();
		int randomInt = r.nextInt(100) + 1;
		log.info("random probablity "+p +" randomInt "+randomInt);
		if(randomInt <= p) return false;
		//获取1-100 随机数   
		return true;
	}
	
	
	
	private void run(){
		List<Long> ids = getTask();
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(99);
//		ids.add(98);
//		ids.add(97);
//		ids.add(96);
		
		
		
		ids.parallelStream().forEach(new Consumer<Long>(){

			public void accept(Long id) {
				// TODO Auto-generated method stub
				if(!isFilter(id)){
					// 选取两条评论 更新它的时间戳为最近日期 
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date());
					calendar.add(Calendar.DAY_OF_MONTH, -30);
					String dt2 = sdf2.format(calendar.getTime());
					String sql = "select id from user_comment where comment_time>'"+dt2+"' and raw_id in (select raw_id from rawid_mergeid_mapping where merge_id='"+id+"') and flag>=0 order by comment_time asc limit 1";
					List<Integer> ids = nativeRepository.queryIntResult(sql);
					if(ids.size() > 0){
					
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String dt = sdf.format(new Date());
						
						
						log.info("comments id is "+ ids.get(0)+"  date:"+dt);
						String updateSql = "update user_comment set update_ts='"+dt+"', detail='"+dt+"' where id="+ids.get(0);
						nativeRepository.update(updateSql);
					}
				
				}
			}
		
		});
	}
	
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				   "classpath:applicationContext.xml");
		FakeCommentTime fct = ac.getBean(FakeCommentTime.class);
		fct.run();
	}
}
