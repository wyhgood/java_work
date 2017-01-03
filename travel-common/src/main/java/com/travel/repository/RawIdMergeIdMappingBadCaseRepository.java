package com.travel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawIdMergeIdMappingBadCase;

@Repository
public interface RawIdMergeIdMappingBadCaseRepository extends JpaRepository<RawIdMergeIdMappingBadCase, Long>{
	@Query("select r from rawid_mergeid_mapping_badcase r where r.city = :city")
	public List<RawIdMergeIdMappingBadCase> findByCity(@Param("city")String city);

	@Query("select r from rawid_mergeid_mapping_badcase r where r.embeddedId.rawId in :rawIds")
	public List<RawIdMergeIdMappingBadCase> findByRawIdIn(@Param("rawIds")List<String> distinctRawIds);

	@Query("select r from rawid_mergeid_mapping_badcase r where r.embeddedId.rawId in :rawIds and r.city = :city")
	public List<RawIdMergeIdMappingBadCase> findByCityAndRawIdIn(@Param("rawIds")List<String> asList, @Param("city")String city);

	@Query("select r from rawid_mergeid_mapping_badcase r where r.createDate >= :startTime and r.createDate <= :endTime order by r.createDate desc")
	public List<RawIdMergeIdMappingBadCase> findByCreateDate(@Param("startTime")Date startTime, @Param("endTime")Date endTime);
}
