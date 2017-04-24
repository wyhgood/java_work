package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.UrlInfo;

@Repository
public interface UrlInfoRepository extends 
JpaRepository<UrlInfo, Long>,JpaSpecificationExecutor<UrlInfo>{
	
	public List<UrlInfo>  findByUrlMd5(String urlMd5);
}