package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.FixReport;

@Repository
public interface FixReportRepository extends JpaRepository<FixReport, Integer>,
		JpaSpecificationExecutor<FixReport> {
	
	@Query("select Max(r.workflowId) from FixReport r")
	public Integer findWorkFlowIds();
	
	@Query("select r.mergeId from FixReport r where r.workflowId = :workflowId and r.city = :city and r.type = :type")
	public List<Long> getByCityIdAndWorkflowId(@Param("workflowId")int workflowId, @Param("city")String city, @Param("type")Integer type);
	
	@Query("select count(r.id) from FixReport r where r.workflowId = :workflowId and r.city = :city and r.type in :type")
	public Number getCountByCityIdAndWorkflowId(@Param("workflowId")int workflowId, @Param("city")String city, @Param("type")List<Integer> type);

	@Query("select r from FixReport r where r.workflowId = :workflowId")
	public List<FixReport> findByWorkflowId(@Param("workflowId")int workflowId);
}
