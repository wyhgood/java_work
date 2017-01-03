package com.travel.repository.auto.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.comment.CommentTemplateManual;
@Repository
public interface CommentTemplateManualRepository extends
		JpaRepository<CommentTemplateManual, Long>,
		JpaSpecificationExecutor<CommentTemplateManual> {

	public List<CommentTemplateManual> findByUserCommentIdAndSentenceIdxAndNounTag(
			Long userCommentId, Integer sentenceIdx, String nounTag);
	
	public List<CommentTemplateManual> findByUserCommentIdAndSentenceIdx(
			Long userCommentId, Integer sentenceIdx);
	
	public List<CommentTemplateManual> findByRawIdAndNounTag(Integer rawId,String nounTag);
	
	public List<CommentTemplateManual> findByRawIdAndNounTagAndPolarity(Integer rawId,String nounTag,Integer polarity);
}
