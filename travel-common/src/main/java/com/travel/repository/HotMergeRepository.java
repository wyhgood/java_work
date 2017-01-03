package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.HotMerge;

@Repository
public interface HotMergeRepository extends JpaRepository<HotMerge, Long>, JpaSpecificationExecutor<HotMerge> {

	@Query("select t from HotMerge t where t.cityid = :cityid")
	public List<HotMerge> findByCityId(@Param("cityid") String cityid);

	public List<HotMerge> findByCnNameAndCityAndTypeAndStatusContainingOrderByRateCountDesc(int cnName, String city, String type, String status);

	public List<HotMerge> findByCnNameAndCityAndTypeOrderByRateCountDesc(int cnName, String city, String type);

	public List<HotMerge> findByCnNameAndCityAndStatusContainingOrderByRateCountDesc(int cnName, String city, String status);

	public List<HotMerge> findByCnNameAndTypeAndStatusContainingOrderByRateCountDesc(int cnName, String type, String status);

	public List<HotMerge> findByCnNameAndCityOrderByRateCountDesc(int cnName, String city);

	public List<HotMerge> findByCnNameAndTypeOrderByRateCountDesc(int cnName, String type);

	public List<HotMerge> findByCnNameAndStatusContainingOrderByRateCountDesc(int cnName, String status);

}
