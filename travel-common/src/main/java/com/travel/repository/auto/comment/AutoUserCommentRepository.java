package com.travel.repository.auto.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.comment.AutoUserComment;

@Repository
public interface AutoUserCommentRepository extends
		JpaRepository<AutoUserComment, Long>, JpaSpecificationExecutor<AutoUserComment> {

	@Modifying
	@Query("delete from auto_user_comment uc where uc.rawId=:rawId")
	public void batchDeleteByRawId(@Param("rawId")Long rawId);
	
	public List<AutoUserComment> findByRawId(Long rawId);
	
	@Query("select MAX(uc.commentTime) from auto_user_comment uc where uc.rawId=:rawId")
	public String getMaxTime(@Param("rawId")Long rawId);
	
	@Query("select uc.commentId from auto_user_comment uc where uc.rawId=:rawId")
	public List<String> getCommentIds(@Param("rawId")Long rawId);
	
	public List<AutoUserComment> findByRawIdAndCommentId(Long rawId,String commentId);
	
	@Query("select uc from auto_user_comment uc where uc.dataLang='' or uc.dataLang='zhCN' or uc.dataLang is null")
	public List<AutoUserComment> findByZhCNLang();
	
	@Query("select count(*) from auto_user_comment uc where uc.rawId=:rawId and (uc.dataLang='' or uc.dataLang is null or uc.dataLang='zhCN')")
	public Long countZhCommentByRawId(@Param("rawId")Long rawId);
	
	@Query("select count(*) from auto_user_comment uc where uc.rawId=:rawId")
	public Long countByRawId(@Param("rawId")Long rawId);
}
