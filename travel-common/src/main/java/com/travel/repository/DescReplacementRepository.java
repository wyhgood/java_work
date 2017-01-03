package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.DescReplacement;
@Repository
public interface DescReplacementRepository extends
		JpaRepository<DescReplacement, Integer>,
		JpaSpecificationExecutor<DescReplacement> {

}
