package com.travel.repository.comment.translator;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.comment.translator.TranslateComment;

@Repository
public interface TranslateCommentRepository extends
		JpaRepository<TranslateComment, Long>,
		JpaSpecificationExecutor<TranslateComment> {
	
	@Query("select tc from translate_comment tc where tc.id>=:sId and tc.id<=:eId")
	public List<TranslateComment> getTranslateCommentById(
			@Param("sId") Long sId, @Param("eId") Long eId);
	@Query("select tc from translate_comment tc where tc.translateModel.rawId=:rawId")
	public List<TranslateComment> findByRawId(@Param("rawId")Integer rawId);
	
	@Query("select tc from translate_comment tc where tc.translateModel.rawId=:rawId"
			+ " and tc.translateModel.fourGramSeScore>:fourGramSeScore"
			+ " and tc.translateModel.biGramSeScore>:biGramSeScore"
			+ " and tc.translateModel.isFinal=:isFinal"
			+ " and tc.translateModel.score>:score"
			+ " and tc.translateModel.threeGramSeScore>:threeGramSeScore"
			+ " and (tc.translateModel.distLen>:distLen or tc.translateModel.emotionScore>:emotionScore)"
			)
	public List<TranslateComment> findByRawIdAndScore(
			@Param("rawId")Integer rawId,
			@Param("score")Double score,
			@Param("fourGramSeScore")Double fourGramSeScore,
			@Param("biGramSeScore")Double biGramSeScore,
			@Param("isFinal")Integer isFinal,
			@Param("distLen")Integer distLen,
			@Param("emotionScore")Double emotionScore,
			@Param("threeGramSeScore")Double threeGramSeScore
			);
	
	@Query("select tc from translate_comment tc where tc.translateModel.ucId=:ucId"
			+ " and tc.translateModel.fourGramSeScore>:fourGramSeScore"
			+ " and tc.translateModel.biGramSeScore>:biGramSeScore"
			+ " and tc.translateModel.isFinal=:isFinal"
			+ " and tc.translateModel.score>:score"
			+ " and tc.translateModel.threeGramSeScore>:threeGramSeScore"
			+ " and (tc.translateModel.distLen>:distLen or tc.translateModel.emotionScore>:emotionScore)"
			+ " order by tc.translateModel.idxInComment asc"
			)
	public List<TranslateComment> findByUcIdAndScore(
			@Param("ucId")Long ucId,
			@Param("score")Double score,
			@Param("fourGramSeScore")Double fourGramSeScore,
			@Param("biGramSeScore")Double biGramSeScore,
			@Param("isFinal")Integer isFinal,
			@Param("distLen")Integer distLen,
			@Param("emotionScore")Double emotionScore,
			@Param("threeGramSeScore")Double threeGramSeScore
			);
}
