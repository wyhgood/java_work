//package com.travel.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.travel.entity.report.PlaceInfoNew;
//
//@Repository
//public interface PlaceInfoNewRepository extends
//		JpaRepository<PlaceInfoNew, Long>,
//		JpaSpecificationExecutor<PlaceInfoNew> {
//	
//	@Query("select count(*) from place_info rd where rd.city=:cityId")
//	public Long countByCity(@Param("cityId")int cityId);
//}
