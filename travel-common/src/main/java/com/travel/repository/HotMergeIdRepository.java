package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.HotMergeId;

@Repository
public interface HotMergeIdRepository extends JpaRepository<HotMergeId, Integer>, JpaSpecificationExecutor<HotMergeId> {

	@Query("select h.mergeId from HotMergeId h where h.syncId = :syncId")
	public List<Integer> getHotMergeId(@Param("syncId") int syncId);

	@Query("select t from HotMergeId t where t.cityid = :cityId")
	public List<HotMergeId> findByCityId(@Param("cityId") String cityId);

	@Query("select t from HotMergeId t where t.cityid = :cityId and t.syncId = :syncId")
	public List<HotMergeId> findByCityIdAndSyncId(@Param("cityId") String cityId, @Param("syncId") int syncId);
}
