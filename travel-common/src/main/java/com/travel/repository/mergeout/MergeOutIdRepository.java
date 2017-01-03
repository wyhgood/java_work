package com.travel.repository.mergeout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.mergeout.MergeOutId;

@Repository
public interface MergeOutIdRepository extends
		JpaRepository<MergeOutId, Long>,
		JpaSpecificationExecutor<MergeOutId> {

}
