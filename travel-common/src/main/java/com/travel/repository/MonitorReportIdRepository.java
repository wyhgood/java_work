package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.MonitorReportId;

@Repository
public interface MonitorReportIdRepository extends
JpaRepository<MonitorReportId, Integer>,
JpaSpecificationExecutor<MonitorReportId> {
	@Query("select m from monitor_report_id m where m.dt=:date and m.status=:status and m.type=:type")
	public List<MonitorReportId> findByOther(@Param("date") String date, @Param("status") Integer status, @Param("type") String type);
}