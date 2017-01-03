package com.travel.repository.auto.desc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.desc.RawDataAutoDesc;

@Repository
public interface RawDataAutoDescRepository extends
		JpaRepository<RawDataAutoDesc, Integer>, JpaSpecificationExecutor<RawDataAutoDesc> {

	public List<RawDataAutoDesc> findByMergeId(Integer mergeId);
}
