package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.PicInfo;

@Repository
public interface PicInfoRepository extends 
		JpaRepository<PicInfo, Long>,JpaSpecificationExecutor<PicInfo> {

	public List<PicInfo> findByRawId(String rawId);
	
	public List<PicInfo> findByUrl(String url);
	
	public List<PicInfo> findByName(String name);
}
