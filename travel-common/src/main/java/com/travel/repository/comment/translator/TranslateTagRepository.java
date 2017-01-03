package com.travel.repository.comment.translator;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.comment.translator.TranslateComment;
import com.travel.entity.comment.translator.TranslateTag;

@Repository
public interface TranslateTagRepository extends
		JpaRepository<TranslateTag, Long>,
		JpaSpecificationExecutor<TranslateTag> {

	@Deprecated
	@Query("select tt from translate_tag tt where tt.translateModel.rawId=:rawId")
	public List<TranslateTag> findByRawId(@Param("rawId")Integer rawId);
	
	@Query("select tt from translate_tag tt where tt.translateModel.rawId=:rawId "
			+ "and tt.translateModel.score>:score")
	public List<TranslateTag> findByRawIdAndScore(
			@Param("rawId") Integer rawId, @Param("score") Double score);
	
	@Query("select tt from translate_tag tt where tt.translateModel.rawId=:rawId "
			+ " and tt.translateModel.score>:score"
			+ " and tt.translateModel.fourGramSeScore>:fourGramSeScore")
	public List<TranslateTag> findByRawIdAndScore(
			@Param("rawId") Integer rawId, 
			@Param("score") Double score,
			@Param("fourGramSeScore")Double fourGramSeScore);
	
	@Query("select tc from translate_tag tc where tc.translateModel.rawId=:rawId"
			+ " and tc.translateModel.fourGramSeScore>:fourGramSeScore"
			+ " and tc.translateModel.biGramSeScore>:biGramSeScore"
			+ " and tc.translateModel.isFinal=:isFinal"
			+ " and tc.translateModel.score>:score"
			+ " and tc.translateModel.threeGramSeScore>:threeGramSeScore"
			+ " and (tc.translateModel.distLen>:distLen or tc.translateModel.emotionScore>:emotionScore)"
			)
	public List<TranslateTag> findByRawIdAndScore(
			@Param("rawId")Integer rawId,
			@Param("score")Double score,
			@Param("fourGramSeScore")Double fourGramSeScore,
			@Param("biGramSeScore")Double biGramSeScore,
			@Param("isFinal")Integer isFinal,
			@Param("distLen")Integer distLen,
			@Param("emotionScore")Double emotionScore,
			@Param("threeGramSeScore")Double threeGramSeScore
			);
}
