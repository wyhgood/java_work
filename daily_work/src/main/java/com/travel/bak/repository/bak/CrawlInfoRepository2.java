package com.travel.bak.repository.bak;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.CrawlInfo;

@Repository
public interface CrawlInfoRepository2 extends 
JpaRepository<CrawlInfo, Long>,JpaSpecificationExecutor<CrawlInfo>{
	
}