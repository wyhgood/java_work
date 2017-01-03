package com.travel.common.entity.service;

import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.entity.RawData;
import com.travel.repository.NativeRepository;
import com.travel.repository.RawDataNativeRepository;
import com.travel.utils.ConfigTool;

@Component
public class RawDataDao extends EntityDao<RawData> implements InitializingBean {
	final static public Logger log = LoggerFactory.getLogger(RawDataDao.class);
	private int isParallel;
	private int pageSize;
	private String sql;
	private String sqlCount;
	private int startPage;
	@Autowired
	private RawDataNativeRepository rawDataRepository;
	@Autowired
	private NativeRepository repository;
	@Override
	public int count(String sql){
		return repository.getCount(sql);
	}
	@Override
	public List<RawData> getByPage(String sql,int currPage,int pageSize){
		return rawDataRepository.getRawDataList(sql, currPage, pageSize);
	}
	@Override
	public void runAllProcess(final CallBackFunc<RawData> call) {
		int total = count(sqlCount);
		log.info("total number:"+total);
		int page = total/pageSize;
		for(int i=startPage;i<=page;i++){
			log.info("progress:"+i+"/"+page);
			List<RawData> rawDatas = getByPage(sql,i,pageSize);
			if(isParallel==1){
				rawDatas.stream().parallel().forEach(new Consumer<RawData>() {
					@Override
					public void accept(RawData t) {
						log.info("run");
						call.run(t);
					}
				});
			}else{
				rawDatas.forEach(new Consumer<RawData>() {
					@Override
					public void accept(RawData t) {
						log.info("run");
						call.run(t);
					}
				});
			}
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getSqlCount() {
		return sqlCount;
	}
	public void setSqlCount(String sqlCount) {
		this.sqlCount = sqlCount;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		isParallel = Integer.parseInt(ConfigTool.props.getProperty("is_parallel", "0"));
		startPage = Integer.parseInt(ConfigTool.props.getProperty("start_page", "1"));
	}
}
