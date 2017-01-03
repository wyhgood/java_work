package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travel.entity.ProcessMonitor;

@Repository
public interface ProcessMonitorRepository extends JpaRepository<ProcessMonitor, Long>, JpaSpecificationExecutor<ProcessMonitor> {
	
	@Query("select p from ProcessMonitor p where p.status = :status order by p.id desc")
	public List<ProcessMonitor> findByStatus(@Param("status")int status);

	@Query("select p from ProcessMonitor p where p.sendEmail = :sendEmail order by p.id desc")
	public List<ProcessMonitor> findBySendEmail(@Param("sendEmail")int sendEmail);
	
	@Query("select p from ProcessMonitor p where p.status = 0 and p.addr = :addr and p.processId = :key")
	public List<ProcessMonitor> findRunnintProcessByAddrAndKey(@Param("addr")String addr, @Param("key")String key);

	@Query("select p from ProcessMonitor p where p.processId = :key order by p.id desc")
	public List<ProcessMonitor> findByLikeKey(@Param("key")String key);

	@Query("select p from ProcessMonitor p where p.addr = :addr order by p.id desc")
	public List<ProcessMonitor> findByAddr(String addr);

	@Query("select p from ProcessMonitor p where p.addr = :addr and p.processId = :pKey and p.threadId = :tKey and p.sendEmail = 1")
	public List<ProcessMonitor> findSendEmailProcess(@Param("addr")String addr, @Param("pKey")String pKey, @Param("tKey")String tKey);
	
	@Query("select p from ProcessMonitor p where p.addr = :addr and p.processId = :pKey and p.threadId is null and p.sendEmail = 1")
	public List<ProcessMonitor> findSendEmailProcess(@Param("addr")String addr, @Param("pKey")String pKey);
}
