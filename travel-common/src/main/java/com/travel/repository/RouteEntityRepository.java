package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.route.RouteEntity;

@Repository
public interface RouteEntityRepository extends
		JpaRepository<RouteEntity, Integer>, JpaSpecificationExecutor<RouteEntity> {
	
	@Query("select count(*) from RouteEntity re where re.url=:url")
	public Long countByUrl(@Param("url")String url);
}