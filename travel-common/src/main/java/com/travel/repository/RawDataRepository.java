package com.travel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawData;

@Repository
public interface RawDataRepository extends JpaRepository<RawData, Integer>, JpaSpecificationExecutor<RawData> {
	@Query("select r from raw_data_mergeout r where r.mergeOutDataModel.status =:status")
	public List<RawData> findByStatus(@Param("status") Integer status);

	@Query("select r from raw_data_mergeout r where r.mergeOutDataModel.quality =:quality")
	public List<RawData> findByQuality(@Param("quality") Double quality);

	@Query("select r from raw_data_mergeout r where r.mergeOutDataModel.status =:status")
	public List<RawData> getByStatus(@Param("status") Integer status);

	public List<RawData> findByMergedId(String mergedId);

	@Query("select count(*) from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strCity=:city")
	public Long countByCity(@Param("city") String city);

	@Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strPlaceType=:placeType")
	public List<RawData> findByPlaceType(@Param("placeType") String placeType);

	@Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strPlaceType=:placeType" + " and rd.mergeOutDataModel.placeInfo.PlaceInfo_strCost_isPredict=:isCostPredict")
	public List<RawData> findByPlaceTypeAndIsPredictCost(@Param("placeType") String placeType, @Param("isCostPredict") Integer isCostPredict);

	@Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.quality>=:quality")
	public List<RawData> findHighQuality(@Param("quality") double quality);

	@Query("select count(*) from raw_data_mergeout rd where rd.mergeOutDataModel.quality>=:quality")
	public Long countHighQuality(@Param("quality") double quality);

	@Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strCity = :city and rd.mergeOutDataModel.idInfo.IdInfo_strPlaceType in :types order by rd.mergeOutDataModel.popularInfo.PopularInfo_strRateCount desc")
	public List<RawData> getCityHotRawData(@Param("city") String city, @Param("types") List<String> types, Pageable pageable);

	// @Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strCity = :city order by rd.mergeOutDataModel.popularInfo.PopularInfo_strRateCount desc")
	@Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strCity = :city")
	public List<RawData> getByCityOrderByRateCount(@Param("city") String city, Pageable pageable);

	@Query("select rd from raw_data_mergeout rd where rd.mergeOutDataModel.idInfo.IdInfo_strCity = :city")
	public List<RawData> getByCity(@Param("city") String city);

	@Query("select distinct rd.mergeOutDataModel.idInfo.IdInfo_strCity from raw_data_mergeout rd")
	public List<String> getCityList();

	@Query("select r from raw_data_mergeout r where r.mergedId in :mergeIdList order by r.mergedId")
	public List<RawData> findByMergedIdIn(@Param("mergeIdList") List<String> mergeIdList);

	@Query("select r from raw_data_mergeout r where r.mergeOutDataModel.idInfo.IdInfo_strCity = :city and r.mergeOutDataModel.idInfo.IdInfo_strPlaceType in :typeList")
	public List<RawData> findByCityAndTypeIn(@Param("city") String city, @Param("typeList") List<String> typeList);
	
	/**
	* 根据name统计 merge out 结果中有多少条记录
	* @param name
	* @return
	*/
	@Query("select count(*) from raw_data_mergeout r where r.mergeOutDataModel.placeInfo.PlaceInfo_strName =:name")
	public double countByPlaceNaem(@Param("name") String name);
}
