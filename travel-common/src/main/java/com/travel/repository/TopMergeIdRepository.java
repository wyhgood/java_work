package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.entity.TopMergeId;

@Repository
public interface TopMergeIdRepository extends JpaRepository<TopMergeId, Long>,
		JpaSpecificationExecutor<TopMergeId> {
	
	@Query("select m.mergeId from TopMergeId m")
	public List<Long> findAllMergeId();
}
