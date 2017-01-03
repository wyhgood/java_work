package com.travel.repository.auto.desc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.desc.RawDataLongDesc;

@Repository
public interface RawDataLongDescRepository extends
		JpaRepository<RawDataLongDesc, Integer>,
		JpaSpecificationExecutor<RawDataLongDesc> {

	public List<RawDataLongDesc> findByAutoDescModelMergeId(Integer mergeId);
}
