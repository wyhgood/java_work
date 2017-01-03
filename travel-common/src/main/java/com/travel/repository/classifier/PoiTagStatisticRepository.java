package com.travel.repository.classifier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.classifier.PoiTagStatistic;

@Repository
public interface PoiTagStatisticRepository extends
		JpaRepository<PoiTagStatistic, Long>,
		JpaSpecificationExecutor<PoiTagStatistic> {

}
