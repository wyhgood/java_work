package com.travel.repository.auto.desc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.desc.RawDataAutoDescChange;

@Repository
public interface RawDataAutoDescChangeRepository extends
		JpaRepository<RawDataAutoDescChange, Integer>, JpaSpecificationExecutor<RawDataAutoDescChange> {
}
