package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.SynonymWord;
import com.travel.entity.SynonymWordId;

@Repository
public interface SynonymWordRepository extends JpaRepository<SynonymWord, SynonymWordId>, JpaSpecificationExecutor<SynonymWord> {

	@Query("select t from SynonymWord t order by t.createTime Desc")
	public List<SynonymWord> findList();

	@Query("select t from SynonymWord t where t.synonymWordId.lNorWord = :word or t.synonymWordId.bNorWord = :word order by t.createTime Desc")
	public List<SynonymWord> findListByWord(@Param("word") String w1);
}
