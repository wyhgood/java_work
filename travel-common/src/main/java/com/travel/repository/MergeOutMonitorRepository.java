package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.*;

@Repository
public interface MergeOutMonitorRepository extends
JpaRepository<MergeOutMonitor, Integer>,
JpaSpecificationExecutor<MergeOutMonitor> {
								
	@Query("select m from merge_out_monitor m where m.city=:city and m.type=:type and m.reportId=:reportId")
	public List<MergeOutMonitor> findByOther(@Param("reportId") Integer reportId,@Param("city") String city, @Param("type") String type);
	
	@Query("select m.id from merge_out_monitor m where m.field=:field and m.updateTs=:date")
	public List<Integer> findIds(@Param("field") String field, @Param("date") String date);
	
	@Query("select m from merge_out_monitor m where m.city=:city and m.type=:type and m.updateTs=:date and m.field=:field")
	public List<MergeOutMonitor> findByOther1(@Param("date") String date, @Param("city") String city, @Param("type") String type, @Param("field") String field);
}