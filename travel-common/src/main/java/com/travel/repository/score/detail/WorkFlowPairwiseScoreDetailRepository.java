package com.travel.repository.score.detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.score.detail.WorkFlowPairwiseScoreDetail;

@Repository
public interface WorkFlowPairwiseScoreDetailRepository extends
		JpaRepository<WorkFlowPairwiseScoreDetail, Long>,
		JpaSpecificationExecutor<WorkFlowPairwiseScoreDetail> {

}
