package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.FootPrint;

@Repository
public interface FootPrintRepository extends JpaRepository<FootPrint, Long>, JpaSpecificationExecutor<FootPrint> {

	@Query("select t from foot_print_test t where t.id >= :startId and t.id <= :endId")
	public List<FootPrint> findByIdRange(@Param("startId") long startId, @Param("endId") long endId);

	@Query("select max(t.id) from foot_print_test t")
	public Long getMaxId();
}
