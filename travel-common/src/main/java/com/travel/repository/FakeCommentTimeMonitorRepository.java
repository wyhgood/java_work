package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.FakeCommentTimeMonitor;

@Repository
public interface FakeCommentTimeMonitorRepository extends 
JpaRepository<FakeCommentTimeMonitor, Long>,JpaSpecificationExecutor<FakeCommentTimeMonitor>{

}