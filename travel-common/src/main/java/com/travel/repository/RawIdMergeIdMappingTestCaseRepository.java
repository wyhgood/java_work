package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawIdMergeIdMappingTestCase;

@Repository
public interface RawIdMergeIdMappingTestCaseRepository extends JpaRepository<RawIdMergeIdMappingTestCase, Long>{
	@Query("select r from rawid_mergeid_mapping_testcase r where r.city = :city")
	public List<RawIdMergeIdMappingTestCase> findByCity(@Param("city")String city);

	@Query("select r from rawid_mergeid_mapping_testcase r where r.embeddedId.rawId in :rawIds")
	public List<RawIdMergeIdMappingTestCase> findByRawIdIn(@Param("rawIds")List<String> distinctRawIds);

	@Query("select r from rawid_mergeid_mapping_testcase r where r.embeddedId.rawId in :rawIds and r.city = :city")
	public List<RawIdMergeIdMappingTestCase> findByCityAndRawIdIn(@Param("rawIds")List<String> asList, @Param("city")String city);

	@Query("select distinct r.embeddedId.mergeId from rawid_mergeid_mapping_testcase r")
	public List<String> findAllMergeId();

	@Query("select r from rawid_mergeid_mapping_testcase r where r.embeddedId.mergeId in :mergeIds")
	public List<RawIdMergeIdMappingTestCase> findByMergeIdIn(@Param("mergeIds")List<String> mergeIds);
}
