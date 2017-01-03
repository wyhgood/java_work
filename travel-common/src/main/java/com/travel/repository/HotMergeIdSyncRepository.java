package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.entity.HotMergeIdSync;

@Repository
public interface HotMergeIdSyncRepository extends JpaRepository<HotMergeIdSync, Integer>, JpaSpecificationExecutor<HotMergeIdSync> {

	@Query("select max(t.id) from HotMergeIdSync t")
	public Integer findMaxSyncId();

}
