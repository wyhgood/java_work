package com.travel.repository.comment.translator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.comment.translator.NGramFreqItem;
@Repository
public interface NGramFreqItemRepository extends
		JpaRepository<NGramFreqItem, Integer>,
		JpaSpecificationExecutor<NGramFreqItem> {

}
