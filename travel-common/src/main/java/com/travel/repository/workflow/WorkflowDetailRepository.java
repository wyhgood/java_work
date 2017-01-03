package com.travel.repository.workflow;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.workflow.WorkflowDetail;
@Repository
public interface WorkflowDetailRepository extends JpaRepository<WorkflowDetail, Long>, JpaSpecificationExecutor<WorkflowDetail> {

	@Query("select w from WorkflowDetail w where w.status in :status and w.createTime >= :startTime and w.createTime <= :endTime order by w.id")
	List<WorkflowDetail> findByStatusInAndDateRange(@Param("status")List<Integer> status, @Param("startTime")Date startTime, @Param("endTime")Date endTime);

	@Query("select w from WorkflowDetail w where w.workflowId = :workflowId and w.fromMergeId in :mergeIdList ")
	public List<WorkflowDetail> findByWorkflowIdAndSplitIdIn(@Param("workflowId")int workflowId, @Param("mergeIdList")List<Long> mergeIdList);
	
	@Query("select w from WorkflowDetail w where w.workflowId = :workflowId and w.toMergeId in :mergeIdList ")
	public List<WorkflowDetail> findByWorkflowIdAndMergeIdIn(@Param("workflowId")int workflowId, @Param("mergeIdList")List<Long> mergeIdList);
	
	@Query("select w from WorkflowDetail w where w.workflowId = :workflowId")
	public List<WorkflowDetail> findByWorkflowId(@Param("workflowId")Integer workflowId);
}
