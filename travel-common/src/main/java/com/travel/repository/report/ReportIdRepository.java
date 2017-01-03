package com.travel.repository.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.report.ReportId;
@Repository
public interface ReportIdRepository extends JpaRepository<ReportId, Long>,
		JpaSpecificationExecutor<ReportId> {

}
