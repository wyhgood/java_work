package com.travel.repository.auto.desc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.desc.RawDataMixLongDescChange;

@Repository
public interface RawDataMixLongDescChangeRepository extends
		JpaRepository<RawDataMixLongDescChange, Integer>,
		JpaSpecificationExecutor<RawDataMixLongDescChange> {
}
