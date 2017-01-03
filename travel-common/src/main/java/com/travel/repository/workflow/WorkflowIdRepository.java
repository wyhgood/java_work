package com.travel.repository.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.workflow.WorkflowId;
@Repository
public interface WorkflowIdRepository extends
		JpaRepository<WorkflowId, Long>,
		JpaSpecificationExecutor<WorkflowId> {

}
