package com.travel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.ExceptionAlarm;

@Repository
public interface ExceptionAlarmRepository extends 
		JpaRepository<ExceptionAlarm, Long>,JpaSpecificationExecutor<ExceptionAlarm> {
}
