package com.travel.repository.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.tag.BrandInfo;
@Repository
public interface BrandInfoRepository extends
		JpaRepository<BrandInfo, Integer>,
		JpaSpecificationExecutor<BrandInfo> {

}
