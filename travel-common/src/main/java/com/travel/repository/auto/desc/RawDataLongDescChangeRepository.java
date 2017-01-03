package com.travel.repository.auto.desc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.desc.RawDataLongDescChange;

@Repository
public interface RawDataLongDescChangeRepository extends
		JpaRepository<RawDataLongDescChange, Integer>,
		JpaSpecificationExecutor<RawDataLongDescChange> {
}
