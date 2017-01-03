package com.travel.repository.auto.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.comment.TransactionConjunction;

@Repository
public interface TransactionConjunctionRepository extends
		JpaRepository<TransactionConjunction, Integer>,
		JpaSpecificationExecutor<TransactionConjunction> {

	
	public List<TransactionConjunction> findByTemplateKey(String templateKey);
}
