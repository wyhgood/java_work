package com.travel.repository.mergeout;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.mergeout.RawDataMergeOutChange;
@Repository
public interface RawDataMergeOutChangeRepository extends
		JpaRepository<RawDataMergeOutChange, Long>,
		JpaSpecificationExecutor<RawDataMergeOutChange> {

	public List<RawDataMergeOutChange> findByMergeOutId(Integer mergeOutId);
	
	@Query("select change.mergeOutDataModel.changeStr from RawDataMergeOutChange change where change.mergeOutId=:mergeOutId")
	public List<String> findChangeStrByMergeOutId(@Param("mergeOutId")Integer mergeOutId);
}
