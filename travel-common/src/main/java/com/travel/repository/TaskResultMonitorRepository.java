package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.TaskResultMonitor;

@Repository
public interface TaskResultMonitorRepository extends JpaRepository<TaskResultMonitor, Long>, JpaSpecificationExecutor<TaskResultMonitor> {

	@Query("select t from TaskResultMonitor t where t.taskKey = :key")
	public List<TaskResultMonitor> findByKey(@Param("key") String key);

	@Query("select distinct t.taskKey from TaskResultMonitor t")
	public List<String> findAllKey();
}
