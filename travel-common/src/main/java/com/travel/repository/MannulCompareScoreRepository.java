package com.travel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.MannulCompareScore;
import com.travel.entity.MannulCompareScoreId;

@Repository
public interface MannulCompareScoreRepository extends JpaRepository<MannulCompareScore, MannulCompareScoreId>, JpaSpecificationExecutor<MannulCompareScore> {

	@Query("select s from MannulCompareScore s where s.id.lRawId = :rawId or s.id.bRawId = :rawId")
	public List<MannulCompareScore> findByRawId(@Param("rawId") long rawId);

	@Query("select s from MannulCompareScore s where s.updateTime >= :startTime and s.updateTime <= :endTime")
	public List<MannulCompareScore> findByUpdateTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	@Query("select s from MannulCompareScore s where s.updateTime >= :startTime and s.updateTime <= :endTime and s.username = :user")
	public List<MannulCompareScore> findByUpdateTimeAndUser(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("user") String user);
}
