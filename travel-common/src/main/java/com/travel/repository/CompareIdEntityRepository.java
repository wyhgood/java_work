package com.travel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.entity.CompareIdEntity;

@Repository
public interface CompareIdEntityRepository extends JpaRepository<CompareIdEntity, Long>,
		JpaSpecificationExecutor<CompareIdEntity> {
	
	@Query("select max(c.id) from CompareIdEntity c where c.status = 3")
	public Long getMaxFinishCompareId();
	
	@Query("select c from CompareIdEntity c order by c.id desc")
	public List<CompareIdEntity> getMaxCompareIdEntity(Pageable pageable);
}
