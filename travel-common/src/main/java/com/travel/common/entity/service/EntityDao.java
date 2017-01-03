package com.travel.common.entity.service;

import java.util.List;

abstract public class EntityDao<T> {
	abstract public int count(String sql);
	abstract public List<T> getByPage(String sql,int currPage,int pageSize);
	abstract public void runAllProcess(CallBackFunc<T> call);
}
