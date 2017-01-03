package com.travel.repository.auto.desc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.desc.RawDataMixLongDesc;

@Repository
public interface RawDataMixLongDescRepository extends
		JpaRepository<RawDataMixLongDesc, Integer>,
		JpaSpecificationExecutor<RawDataMixLongDesc> {

	public List<RawDataMixLongDesc> findByAutoDescModelMergeId(Integer mergeId);
}
