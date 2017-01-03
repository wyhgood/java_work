package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawIdMergeIdMapping;

@Repository
public interface RawIdMergeIdMappingRepository extends JpaRepository<RawIdMergeIdMapping, Long>{

	@Query("select r from rawid_mergeid_mapping r where r.embeddedId.rawId=:rawId")
	public List<RawIdMergeIdMapping> getFromRawId(@Param("rawId")String rawId);
	
	@Query("select r from rawid_mergeid_mapping r where r.embeddedId.mergeId=:mergeId")
	public List<RawIdMergeIdMapping> getFromMergeId(@Param("mergeId")String mergeId);
	
	@Query("select r from rawid_mergeid_mapping r where r.embeddedId.rawId=:rawId and r.embeddedId.mergeId=:mergeId")
	public List<RawIdMergeIdMapping> findByRawIdAndMergeId(@Param("rawId")String rawId,@Param("mergeId")String mergeId);

	/**
	 * 通过rawIds获取对应的Mapping关系
	 * 
	 * @param rawIds
	 * @return
	 */
	@Query("select r from rawid_mergeid_mapping r where r.embeddedId.rawId in :rawIds")
	public List<RawIdMergeIdMapping> findByRawIdIn(@Param("rawIds")List<String> rawIds);

	/**
	 * 通过mergeIds获取对应的Mapping关系
	 * @param mergeIds
	 * @return
	 */
	@Query("select r from rawid_mergeid_mapping r where r.embeddedId.mergeId in :mergeIds")
	public List<RawIdMergeIdMapping> findByMergeIdIn(@Param("mergeIds")List<String> mergeIds);
	
	@Query("select r.embeddedId.rawId from rawid_mergeid_mapping r where r.embeddedId.mergeId in :mergeIds")
	public List<String> findRawIdByMergeIdIn(@Param("mergeIds")List<String> mergeIds);

	@Query("select r from rawid_mergeid_mapping r group by merge_id having count(raw_id) > 1")
	public List<RawIdMergeIdMapping> findMergedMapping();
	
	@Query("select r from rawid_mergeid_mapping r group by merge_id having count(raw_id) = 1")
	public List<RawIdMergeIdMapping> findCreatedMapping();
}
