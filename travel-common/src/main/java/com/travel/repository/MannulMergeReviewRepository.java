package com.travel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.MannulMergeReview;

@Repository
public interface MannulMergeReviewRepository extends JpaRepository<MannulMergeReview, Long>, JpaSpecificationExecutor<MannulMergeReview> {
	@Query("select m from MannulMergeReview m")
	public List<MannulMergeReview> findByPage(Pageable pageable);

	@Query("select m from MannulMergeReview m where m.rawId in :rawIdList")
	public List<MannulMergeReview> findByRawIdIn(@Param("rawIdList") List<Long> rawIdList);

	@Query("select m from MannulMergeReview m order by m.mergeId")
	public List<MannulMergeReview> findByPageOrderByMergeId(Pageable pageable);

	@Query("select m from MannulMergeReview m where m.mergeId = :mergeId")
	public List<MannulMergeReview> findByMergeId(@Param("mergeId")Long mergeId);
}
