package com.travel.repository.score.detail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.score.detail.BasePairwiseScoreDetail;

@Repository
public interface BasePairwiseScoreDetailRepository extends
		JpaRepository<BasePairwiseScoreDetail, Long>, 
		JpaSpecificationExecutor<BasePairwiseScoreDetail> {
	
	@Query("select bpsd from BasePairwiseScoreDetail bpsd where bpsd.scoreDetail.sRawId=:sRawId and bpsd.scoreDetail.lRawId=:lRawId")
	public List<BasePairwiseScoreDetail> findBysRawIdAndlRawId(@Param("sRawId")Integer sRawId,@Param("lRawId")Integer lRawId);
}
