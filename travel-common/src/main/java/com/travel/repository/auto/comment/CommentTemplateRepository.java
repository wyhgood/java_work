package com.travel.repository.auto.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.comment.CommentTemplate;

@Repository
public interface CommentTemplateRepository extends
		JpaRepository<CommentTemplate, Long>,
		JpaSpecificationExecutor<CommentTemplate> {

	public List<CommentTemplate> findByUserCommentIdAndSentenceIdxAndNounTag(
			Long userCommentId, Integer sentenceIdx, String nounTag);

	public List<CommentTemplate> findByUserCommentIdAndSentenceIdx(
			Long userCommentId, Integer sentenceIdx);

	/**
	 * rawId+nounTag做为 db index
	 * 
	 * @param rawId
	 * @param nounTag
	 * @return
	 */
	public List<CommentTemplate> findByRawIdAndNounTag(Integer rawId,
			String nounTag);

	public List<CommentTemplate> findByRawIdAndNounTagAndPolarity(
			Integer rawId, String nounTag, Integer polarity);

	public List<CommentTemplate> findByNounTagAndPlaceType(String nounTag,
			String placeType);

	public List<CommentTemplate> findByNounTagAndPlaceTypeAndStatus(
			String nounTag, String placeType, Integer status);
	
	public List<CommentTemplate> findByNounTagAndPlaceTypeAndStatusAndPolarity(
			String nounTag, String placeType, Integer status,Integer polarity);
	
	public List<CommentTemplate> findByNounTagAndStatus(String nounTag,
			Integer status);

	public List<CommentTemplate> findByRawIdAndNounTagAndPlaceType(
			Integer rawId, String nounTag, String placeType);

	public List<CommentTemplate> findByRawIdAndNounTagAndPlaceTypeAndPolarity(
			Integer rawId, String nounTag, String placeType, Integer polarity);

	public List<CommentTemplate> findByRawIdAndNounTagAndPlaceTypeAndPolarityAndStatus(
			Integer rawId, String nounTag, String placeType, Integer polarity,
			Integer status);
}
