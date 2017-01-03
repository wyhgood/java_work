package com.travel.repository.brand;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.brand.DishInfo;

@Repository
public interface DishInfoRepository extends
	JpaRepository<DishInfo, Integer>,
	JpaSpecificationExecutor<DishInfo> {

	public List<DishInfo> findByNameEnLowerCase(String nameEnLowerCase);
	
	public List<DishInfo> findByNameZhLowerCase(String nameZhLowerCase);
	
	@Query("select count(*) from dish_info bin where bin.ts>:ts")
	public Long countByTs(@Param("ts")Date ts);
}
