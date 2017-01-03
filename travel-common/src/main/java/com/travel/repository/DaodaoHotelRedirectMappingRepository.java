package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.DaodaoHotelRedirectMapping;

@Repository
public interface DaodaoHotelRedirectMappingRepository extends JpaRepository<DaodaoHotelRedirectMapping, Long> {

	@Query("select t from DaodaoHotelRedirectMapping as t where t.rawId = :id and t.type = :type")
	public List<DaodaoHotelRedirectMapping> findByRawIdAndType(@Param("id") long id, @Param("type") String type);

	@Query("select t from DaodaoHotelRedirectMapping as t where t.rawId = :id")
	public List<DaodaoHotelRedirectMapping> findByRawId(@Param("id") long id);

	@Query("select t from DaodaoHotelRedirectMapping as t where t.daodaoId = :id")
	public List<DaodaoHotelRedirectMapping> findByDaodaoId(@Param("id") String id);

	@Query("select t from DaodaoHotelRedirectMapping as t where t.toUrl is not null and t.httpStatus != 404")
	public List<DaodaoHotelRedirectMapping> findByToUrlNotNull();
	
	public List<DaodaoHotelRedirectMapping> findByType(String type);
}