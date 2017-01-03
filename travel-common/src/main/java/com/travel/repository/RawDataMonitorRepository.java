package com.travel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawDataMonitor;

@Repository
public interface RawDataMonitorRepository extends
JpaRepository<RawDataMonitor, Integer>,
JpaSpecificationExecutor<RawDataMonitor> {
	@Query("select m from raw_data_monitor m where m.city=:city and m.type=:type and m.reportId=:reportId and m.source=:source")
	public List<RawDataMonitor> findByOther(@Param("reportId") Integer reportId,@Param("city") String city, @Param("type") String type, @Param("source") String source);
	
	@Query("select id from raw_data_monitor m where m.date=:date")
	public List<Integer> findIds(@Param("date") String date);
	
	@Query("select m from raw_data_monitor m where m.city=:city and m.type=:type and m.date=:date and m.source=:source and m.country=:country")
	public List<RawDataMonitor> findByOther1(@Param("date") String date, @Param("city") String city, @Param("type") String type, @Param("source") String source, @Param("country") String country);
	
}