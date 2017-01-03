package com.travel.repository.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.report.PlaceInfoDebugInfo;

@Repository
public interface PlaceInfoDebugInfoRepository extends
		JpaRepository<PlaceInfoDebugInfo, Long>,
		JpaSpecificationExecutor<PlaceInfoDebugInfo> {

}
