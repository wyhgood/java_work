package com.travel.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.comment.UserCommentTest;

@Repository
public interface UserCommentTestRepository extends
		JpaRepository<UserCommentTest, Long>, JpaSpecificationExecutor<UserCommentTest> {

	@Modifying
	@Query("delete from user_comment_test uc where uc.rawId=:rawId")
	public void batchDeleteByRawId(@Param("rawId")Long rawId);
	
	public List<UserCommentTest> findByRawId(Long rawId);
	
	@Query("select MAX(uc.commentTime) from user_comment_test uc where uc.rawId=:rawId")
	public String getMaxTime(@Param("rawId")Long rawId);
	
	@Query("select uc.commentId from user_comment_test uc where uc.rawId=:rawId")
	public List<String> getCommentIds(@Param("rawId")Long rawId);
	
	public List<UserCommentTest> findByRawIdAndCommentId(Long rawId,String commentId);
	
	@Query("select uc from user_comment_test uc where uc.dataLang='' or uc.dataLang='zhCN' or uc.dataLang is null")
	public List<UserCommentTest> findByZhCNLang();
	
	@Query("select count(*) from user_comment_test uc where uc.rawId=:rawId and (uc.dataLang='' or uc.dataLang is null or uc.dataLang='zhCN')")
	public Long countZhCommentByRawId(@Param("rawId")Long rawId);
	
	@Query("select count(*) from user_comment_test uc where uc.rawId=:rawId")
	public Long countByRawId(@Param("rawId")Long rawId);
}
