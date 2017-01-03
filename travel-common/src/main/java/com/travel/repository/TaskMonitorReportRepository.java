package com.travel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.TaskMonitorReport;

@Repository
public interface TaskMonitorReportRepository extends JpaRepository<TaskMonitorReport, Long>, JpaSpecificationExecutor<TaskMonitorReport> {

	@Query("select t from TaskMonitorReport t where t.taskKey=:key and t.createTime >= :startDate and t.createTime < :endDate")
	public List<TaskMonitorReport> findByKeyAndDateRange(@Param("key") String key, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
