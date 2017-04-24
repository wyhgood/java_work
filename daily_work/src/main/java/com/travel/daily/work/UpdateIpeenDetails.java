package com.travel.daily.work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.travel.common.nlp.EnglistWordClassifer;
import com.travel.repository.NativeRepository;
import com.travel.utils.TravelUtils;

@Component
public class UpdateIpeenDetails{
	static public final Log log = LogFactory.getLog(UpdateIpeenDetails.class);

	//获取ipeen的所有rawid     任务分发
	@Autowired
	private NativeRepository nativeRepository;
	@Autowired
    private EnglistWordClassifer englistWordClassifer;
	
	
	private void run(){
		String sql = "select id from raw_data where IdInfo_strSource='ipeen'";
		List<Integer> ids = nativeRepository.queryIntResult(sql);
		ids.parallelStream().forEach(new Consumer<Integer>(){

			public void accept(Integer t) {
				// TODO Auto-generated method stub
				//update     detail and  en
				//获取 评论条数 
				try{
					String sqlCommentText = "select id,comment_text from user_comment where update_ts<'2017-03-13 00:00:00' and raw_id='"+t+"'";
					List<Object[]> commentTextNum = nativeRepository.query(sqlCommentText);
							
					
					for(Object[] s:commentTextNum){
						if(s.length == 2){
							String id = String.valueOf(s[0]);
							String commentText = String.valueOf(s[1]);
							String dataLang = genDataLang(commentText);
							//更新 该id下的 detail 和 datalang
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String dt = sdf.format(new Date());
							String updateSql = "update user_comment set detail=NULL, data_lang='"+dataLang+"' , update_ts='"+dt+"' where id="+id ;
							nativeRepository.update(updateSql);
						}
					}
				}catch(Exception e){
					log.info("exception error\t"+e);
				}
			
			}
			
		});
	}
	
	public String genDataLang(String comment){
		if(TravelUtils.isTraditionalChineseSentence(comment)) return "zhTW";
		if(TravelUtils.isChineseSentence(comment, 0.6))return "zhCN";
		if(TravelUtils.isContainJapanese(comment))return "jp";
		if(englistWordClassifer.isEnglishSentence(comment)) return "en";
		return "other";
	}
	
	
	
	
	
	public static void main(String[] args){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				   "classpath:applicationContext.xml");
		UpdateIpeenDetails job = ac.getBean(UpdateIpeenDetails.class);
		job.run();
	}
}