package com.travel.bak.repository.bak;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.UrlInfo;

@Repository
public interface UrlInfoRepository2 extends 
JpaRepository<UrlInfo, Long>,JpaSpecificationExecutor<UrlInfo>{
	
}