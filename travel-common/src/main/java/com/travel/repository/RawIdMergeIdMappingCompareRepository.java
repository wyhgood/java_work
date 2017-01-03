package com.travel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawIdMergeIdMappingCompare;

@Repository
public interface RawIdMergeIdMappingCompareRepository extends
		JpaRepository<RawIdMergeIdMappingCompare, Long>,
		JpaSpecificationExecutor<RawIdMergeIdMappingCompare> {
	
	@Query("select count(r.compareId) from rawid_mergeid_mapping_compare r where r.compareId = :compareId")
	public Long getTotalCount(@Param("compareId")long compareId);
	
	@Query("select r from rawid_mergeid_mapping_compare r where r.compareId = :compareId order by r.id")
	public List<RawIdMergeIdMappingCompare> findByCompareId(@Param("compareId")long compareId, Pageable pageable);
}
