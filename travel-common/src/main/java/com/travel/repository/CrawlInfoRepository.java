package com.travel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.CrawlInfo;

@Repository
public interface CrawlInfoRepository extends 
JpaRepository<CrawlInfo, Long>,JpaSpecificationExecutor<CrawlInfo>{
	
}