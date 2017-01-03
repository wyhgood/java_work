package com.travel.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.comment.HighQualityComment;

@Repository
public interface HighQualityCommentRepository extends
		JpaRepository<HighQualityComment, Long>,
		JpaSpecificationExecutor<HighQualityComment> {

	public List<HighQualityComment> findByMergeId(Integer mergeId);
}