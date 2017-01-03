package com.travel.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.report.SourceReportItem;

@Repository
public interface SourceReportItemRepository extends
		JpaRepository<SourceReportItem, Long>,
		JpaSpecificationExecutor<SourceReportItem> {

	public List<SourceReportItem> findByReportIdAndCityAndPlaceTypeAndScoreType(Long reportId,
			String city,String placeType,Integer scoreType);
}
