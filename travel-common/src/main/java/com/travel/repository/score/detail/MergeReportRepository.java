package com.travel.repository.score.detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.score.detail.MergeReport;
@Repository
public interface MergeReportRepository extends
		JpaRepository<MergeReport, Integer>,
		JpaSpecificationExecutor<MergeReport> {

}
