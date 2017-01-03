package com.travel.repository.fetcher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.fetcher.PageDetail;
@Repository("pageDetailRepository")
public interface PageDetailRepository extends JpaRepository<PageDetail, Long>,
		JpaSpecificationExecutor<PageDetail> {
	
	public List<PageDetail> findByRawId(Long rawId);

}
