package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.MergeIdEntity;

@Repository
public interface MergeIdEntityRepository extends
		JpaRepository<MergeIdEntity, Long>,
		JpaSpecificationExecutor<MergeIdEntity> {

	@Query("select m from MergeIdEntity m where m.id>:id")
	public List<MergeIdEntity> findFromId(@Param("id") Long id);
}
