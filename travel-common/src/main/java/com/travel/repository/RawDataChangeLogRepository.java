package com.travel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawDataChangeLog;

@Repository
public interface RawDataChangeLogRepository extends JpaRepository<RawDataChangeLog, Integer>, JpaSpecificationExecutor<RawDataChangeLog> {
	@Query("select t from RawDataChangeLog t where t.rawId = :rawId order by id desc")
	public List<RawDataChangeLog> findByRawId(@Param("rawId") int rawId);

	@Query("select t from RawDataChangeLog t where t.username = :username and t.createTime >= :start and t.createTime <= :end order by id desc")
	public List<RawDataChangeLog> findByCreateTimeAndUsername(@Param("start") Date start, @Param("end") Date end, @Param("username") String username);
}
