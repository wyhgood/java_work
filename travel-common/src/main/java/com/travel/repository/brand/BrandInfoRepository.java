package com.travel.repository.brand;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.brand.BrandInfo;

@Repository("brandInfoNewRepository")
public interface BrandInfoRepository extends
	JpaRepository<BrandInfo, Integer>,
	JpaSpecificationExecutor<BrandInfo> {

	public List<BrandInfo> findByNameEnLowerCase(String nameEnLowerCase);
	
	public List<BrandInfo> findByNameZhLowerCase(String nameZhLowerCase);
	
	@Query("select count(*) from brand_info_new bin where bin.ts>:ts")
	public Long countByTs(@Param("ts")Date ts);
}
