package com.travel.repository;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.travel.data.RawDataBase;
import com.travel.data.ScoreInfo;
import com.travel.entity.DistributionInfo;
import com.travel.entity.HotelInfo;
import com.travel.entity.IdInfo;
import com.travel.entity.MallInfo;
import com.travel.entity.PlaceInfo;
import com.travel.entity.PopularInfo;
import com.travel.entity.QualityInfo;
import com.travel.entity.RawData;
import com.travel.entity.RestaurantInfo;
import com.travel.entity.Round1Info;
import com.travel.entity.ViewInfo;
import com.travel.entity.mergeout.MergeOutDataModel;
import com.travel.utils.DateUtils;
import com.travel.utils.TravelUtils;

@Component("rawDataNativeRepository")
public class RawDataNativeRepository {
	Logger log = LoggerFactory.getLogger(RawDataNativeRepository.class);
	@Autowired
	private NativeRepository repostory;

	public RawData createRawData(Object[] strs) {
		RawData rawData = new RawData();
		MergeOutDataModel dataModel = new MergeOutDataModel();
		rawData.setMergeOutDataModel(dataModel);
		rawData.setId(Integer.parseInt(strs[0].toString()));
		IdInfo idinfo = new IdInfo();
		rawData.getMergeOutDataModel().setIdInfo(idinfo);

		PlaceInfo placeinfo = new PlaceInfo();
		rawData.getMergeOutDataModel().setPlaceInfo(placeinfo);

		PopularInfo popularInfo = new PopularInfo();
		rawData.getMergeOutDataModel().setPopularInfo(popularInfo);

		RestaurantInfo restaurantinfo = new RestaurantInfo();
		rawData.getMergeOutDataModel().setRestaurantInfo(restaurantinfo);

		MallInfo mallinfo = new MallInfo();
		rawData.getMergeOutDataModel().setMailInfo(mallinfo);

		ViewInfo viewinfo = new ViewInfo();
		rawData.getMergeOutDataModel().setViewInfo(viewinfo);

		String IdInfo_strSource = strs[1].toString();
		String IdInfo_strId = strs[2].toString();
		String IdInfo_strURL = strs[3].toString();
		String IdInfo_strCity = strs[4].toString();
		String IdInfo_strCountry = strs[5].toString();
		String IdInfo_strPlaceType = strs[6].toString();

		idinfo.setIdInfo_strSource(IdInfo_strSource);
		idinfo.setIdInfo_strId(IdInfo_strId);
		idinfo.setIdInfo_strURL(IdInfo_strURL);
		idinfo.setIdInfo_strPlaceType(IdInfo_strPlaceType);
		idinfo.setIdInfo_strCity(IdInfo_strCity);
		idinfo.setIdInfo_strCountry(IdInfo_strCountry);

		String PlaceInfo_strLat = strs[7].toString();
		String PlaceInfo_strLng = strs[8].toString();
		String PlaceInfo_strName = strs[9].toString();
		String PlaceInfo_strAddress = strs[10].toString();
		String PlaceInfo_strOpenTime = strs[11].toString();
		String PlaceInfo_strTraffic = strs[12].toString();
		String PlaceInfo_strMainPic = strs[13].toString();
		String PlaceInfo_strDesc = strs[14].toString();
		String PlaceInfo_strCost = strs[15].toString();
		String PlaceInfo_listTelephone = strs[16].toString();
		String PlaceInfo_listAliasName = strs[17].toString();
		String PlaceInfo_listPics = strs[18].toString();

		placeinfo.setPlaceInfo_strLat(PlaceInfo_strLat);
		placeinfo.setPlaceInfo_strLng(PlaceInfo_strLng);
		placeinfo.setPlaceInfo_strName(PlaceInfo_strName);
		placeinfo.setPlaceInfo_strAddress(PlaceInfo_strAddress);
		placeinfo.setPlaceInfo_strOpenTime(PlaceInfo_strOpenTime);
		placeinfo.setPlaceInfo_strTraffic(PlaceInfo_strTraffic);
		placeinfo.setPlaceInfo_strMainPic(PlaceInfo_strMainPic);
		placeinfo.setPlaceInfo_strDesc(PlaceInfo_strDesc);
		placeinfo.setPlaceInfo_strCost(PlaceInfo_strCost);
		placeinfo.setPlaceInfo_listTelephone(PlaceInfo_listTelephone);
		placeinfo.setPlaceInfo_listAliasName(PlaceInfo_listAliasName);
		placeinfo.setPlaceInfo_listPics(PlaceInfo_listPics);

		String PopularInfo_strProductScore = strs[19].toString();
		String PopularInfo_strEnviromentScore = strs[20].toString();
		String PopularInfo_strServiceScore = strs[21].toString();
		String PopularInfo_strScore = strs[22].toString();
		String PopularInfo_strRateCount = strs[23].toString();
		String PopularInfo_listUserComment = strs[24].toString();
		String PopularInfo_listTags = strs[25].toString();

		popularInfo.setPopularInfo_strProductScore(TravelUtils.parseDouble(PopularInfo_strProductScore));
		popularInfo.setPopularInfo_strEnviromentScore(TravelUtils.parseDouble(PopularInfo_strEnviromentScore));
		popularInfo.setPopularInfo_strServiceScore(TravelUtils.parseDouble(PopularInfo_strServiceScore));
		popularInfo.setPopularInfo_strScore(TravelUtils.parseDouble(PopularInfo_strScore));
		popularInfo.setPopularInfo_strRateCount(TravelUtils.parseDouble(PopularInfo_strRateCount));
		popularInfo.setPopularInfo_listUserComment(PopularInfo_listUserComment);
		popularInfo.setPopularInfo_listTags(PopularInfo_listTags);
		popularInfo.setPopularInfo_userCommentSize(0);

		String RestaurantInfo_listRecommendFood = strs[26].toString();
		String RestaurantInfo_listFoodWithPic = strs[27].toString();
		String RestaurantInfo_listFoodType = strs[28].toString();

		restaurantinfo.setRestaurantInfo_listRecommendFood(RestaurantInfo_listRecommendFood);
		restaurantinfo.setRestaurantInfo_listFoodWithPic(RestaurantInfo_listFoodWithPic);
		restaurantinfo.setRestaurantInfo_listFoodType(RestaurantInfo_listFoodType);

		String MallInfo_listPics = strs[29].toString();
		String MallInfo_listRecommendShop = strs[30].toString();

		mallinfo.setMallInfo_listPics(MallInfo_listPics);
		mallinfo.setMallInfo_listRecommendShop(MallInfo_listRecommendShop);

		String ViewInfo_strEntrancePrice = strs[31].toString();
		String ViewInfo_listPic = strs[32].toString();
		String ViewInfo_listRecommendPlay = strs[33].toString();

		viewinfo.setViewInfo_listPic(ViewInfo_listPic);
		viewinfo.setViewInfo_listRecommendPlay(ViewInfo_listRecommendPlay);
		viewinfo.setViewInfo_strEntrancePrice(ViewInfo_strEntrancePrice);

		String mergedId = strs[34].toString();
		rawData.setMergedId(mergedId);
		Integer status = Integer.parseInt(strs[35].toString());
		rawData.getMergeOutDataModel().setStatus(status);

		HotelInfo hotel = new HotelInfo();
		hotel.setHotelInfo_strStar(strs[38].toString());
		hotel.setHotelInfo_strRoomNum(strs[39].toString());
		hotel.setHotelInfo_listFacility(strs[40].toString());
		rawData.getMergeOutDataModel().setHotelInfo(hotel);
		if (strs.length >= 44) {
			rawData.setIsFetchComment(Integer.parseInt(strs[42].toString()));
			rawData.setCommentTs(strs[43].toString());
		}
		if (strs.length >= 45) {
			if (strs[44] != null) {
				rawData.getMergeOutDataModel().getViewInfo().setViewInfo_strCostTime(strs[44].toString());
			}
		}

		if (strs.length >= 56) {
			placeinfo.setPlaceInfo_strStreetAddress(strs[45].toString());
			placeinfo.setPlaceInfo_strExtAddress(strs[46].toString());
			placeinfo.setPlaceInfo_strLocality(strs[47].toString());
			placeinfo.setPlaceInfo_strCountry(strs[48].toString());
			placeinfo.setPlaceInfo_strPostCode(strs[49].toString());
			placeinfo.setPlaceInfo_strLocalStreetAddress(strs[50].toString());
			placeinfo.setPlaceInfo_strLocalExtAddress(strs[51].toString());
			placeinfo.setPlaceInfo_strLocalLocality(strs[52].toString());
			placeinfo.setPlaceInfo_strLocalCountry(strs[53].toString());
			placeinfo.setPlaceInfo_strLocalPostCode(strs[54].toString());
			placeinfo.setPlaceInfo_strLocalName(strs[55].toString());
			placeinfo.setPlaceInfo_strRegion(strs[56].toString());
			placeinfo.setPlaceInfo_strLocalRegion(strs[57].toString());
		}
		mallinfo.setMallInfo_listMallType(strs[58] == null ? "" : strs[58].toString());
		viewinfo.setViewInfo_listViewType(strs[59] == null ? "" : strs[59].toString());
		if (strs.length > 60) {
			Round1Info round1Info = new Round1Info();
			rawData.setRound1Info(round1Info);
			round1Info.setRound1Info_listNames(strs[60] == null ? "" : strs[60].toString());
			round1Info.setRound1Info_listBranchNames(strs[61] == null ? "" : strs[61].toString());
			round1Info.setRound1Info_strChainShopCount(strs[62] == null ? "" : strs[62].toString());
			round1Info.setRound1Info_strShadowPoi(strs[63] == null ? "" : strs[63].toString());
			round1Info.setRound1Info_strChainCluster(strs[64] == null ? "" : strs[64].toString());
			round1Info.setRound1Info_listBadTel(strs[65] == null ? "" : strs[65].toString());
		}
		if (strs.length > 70) {
			placeinfo.setPlaceInfo_strPoLocalName(strs[67] == null ? "" : strs[67].toString());
			placeinfo.setPlaceInfo_strPoEnName(strs[68] == null ? "" : strs[68].toString());
			placeinfo.setPlaceInfo_strPoCnName(strs[69] == null ? "" : strs[69].toString());
			placeinfo.setPlaceInfo_strPoLocalAddress(strs[70] == null ? "" : strs[70].toString());
			placeinfo.setPlaceInfo_strPoEnAddress(strs[71] == null ? "" : strs[71].toString());
			placeinfo.setPlaceInfo_strPoCnAddress(strs[72] == null ? "" : strs[72].toString());
		}
		Gson gson = new Gson();
		if (strs.length > 73) {
			if(strs[73] != null){
				Map<String, Integer> unchangedFieldMap = gson.fromJson(strs[73].toString(),
						new TypeToken<Map<String, Integer>>() {}.getType());
				rawData.unchangedFieldMap = unchangedFieldMap;
			}else{
				rawData.unchangedFieldMap = new HashMap<String,Integer>();
			}
		}
		rawData.setScore(new ScoreInfo());
		QualityInfo qualityInfo = new QualityInfo();
		qualityInfo.setRateCount(0.);
		qualityInfo.setInfoScore(0.);
		qualityInfo.setOriginInfoScore(0.);
		qualityInfo.setStarScore(0.);
		qualityInfo.setCommentScore(0.);
		rawData.getMergeOutDataModel().setQualityInfo(qualityInfo);
		rawData.getMergeOutDataModel().setDistInfo(new DistributionInfo());
		return rawData;
	}

	public RawData findOne(int id) {
		Object[] strs = this.repostory.findOne("select * from raw_data where id=" + id);
		if (strs == null) {
			log.warn("it should not be NULL,WARNING!");
			return null;
		}
		RawData rd = this.createRawData(strs);
		return rd;
	}

	public RawData findOneExist(int id) {
		Object[] strs = this.repostory.findOne("select * from raw_data where id=" + id + " and status != -1");
		if (strs == null) {
			log.warn("it should not be NULL,WARNING!");
			return null;
		}
		RawData rd = this.createRawData(strs);
		return rd;
	}

	public List<Object[]> findCityByIdIn(List<Integer> ids) {
		StringBuilder sqlBuilder = new StringBuilder("select id,  IdInfo_strCity from raw_data where id in (");
		for (int id : ids) {
			sqlBuilder.append(id);
			sqlBuilder.append(",");
		}
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		sqlBuilder.append(") ");
		sqlBuilder.append("and status > 0");

		List<Object[]> objectsList = this.repostory.executeSQL(sqlBuilder.toString());

		if (objectsList == null) {
			log.warn("it should not be NULL,WARNING!");
			return null;
		}

		return objectsList;
	}

	public List<RawData> findByIdIn(List<Integer> ids) {
		List<RawData> resultList = new ArrayList<RawData>();
		StringBuilder sqlBuilder = new StringBuilder("select * from raw_data where id in (");
		for (int id : ids) {
			sqlBuilder.append(id);
			sqlBuilder.append(",");
		}
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		sqlBuilder.append(") ");

		sqlBuilder.append("and status > 0");

		List<Object[]> objectsList = this.repostory.executeSQL(sqlBuilder.toString());

		if (objectsList == null) {
			log.warn("it should not be NULL,WARNING!");
			return null;
		}

		for (Object[] objects : objectsList) {
			RawData rd = this.createRawData(objects);
			resultList.add(rd);
		}

		return resultList;
	}

	public RawData findByRawId(String rawId) {
		String sql = "select * from raw_data where IdInfo_strId='" + rawId + "'";
		log.info(sql);
		Object[] strs = this.repostory.findOne(sql);
		if (strs == null) {
			log.warn("it should not be NULL,WARNING!");
			return null;
		}
		RawData rd = this.createRawData(strs);
		return rd;
	}

	public List<Object[]> query(String sql) {
		return this.repostory.query(sql);
	}

	public List<RawData> queryRawData(String sql) {
		List<Object[]> objs = query(sql);
		List<RawData> rds = new ArrayList<RawData>();
		for (Object[] obj : objs) {
			RawData rd = this.createRawData(obj);
			rds.add(rd);
		}
		return rds;
	}

	public List<RawData> findByStatus(int status) {
		List<RawData> rawDatas = new ArrayList<RawData>();
		List<Object[]> results = this.repostory.query("select * from raw_data where status=" + status + " limit 100");
		// List<Object[]> results =
		// this.repostory.query("select * from raw_data");
		log.info("result size:" + results.size());
		for (int i = 0; i < results.size(); i++) {
			Object[] strs = results.get(i);
			RawData rd = this.createRawData(strs);
			rawDatas.add(rd);
		}
		return rawDatas;
	}

	public List<RawData> findAllByStatus(int status) {
		List<RawData> rawDatas = new ArrayList<RawData>();
		List<Object[]> results = this.repostory.query("select * from raw_data where status=" + status);
		// List<Object[]> results =
		// this.repostory.query("select * from raw_data");
		log.info("result size:" + results.size());
		for (int i = 0; i < results.size(); i++) {
			Object[] strs = results.get(i);
			RawData rd = this.createRawData(strs);
			rawDatas.add(rd);
		}
		return rawDatas;
	}

	public void updateStatus(List<RawData> rawDatas) {
		for (RawData rd : rawDatas) {
			updateStatus(rd);
		}
	}

	public void updateStatus(RawData rawData) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set " + "status=" + rawData.getMergeOutDataModel().getStatus() + " , last_modify_time='" + currTs + "' where id=" + rawData.getId();
		log.info(sql);
		this.repostory.update(sql);
	}
	public void updatePrice(RawData rawData){
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set PlaceInfo_strCost='"
				+ rawData.getMergeOutDataModel().getPlaceInfo()
						.getPlaceInfo_strCost() + "' , last_modify_time='"
				+ currTs + "' where id=" + rawData.getId();
		log.info(sql);
		this.repostory.update(sql);
	}
	public void updateCommentTs(Integer rawId) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update user_comment set update_ts='" + currTs + "' where raw_id=" + rawId;
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateCommentTs(List<Integer> rawIds) {
		String currTs = DateUtils.getCurrDateStr();
		List<String> rawIdStrs = new ArrayList<String>();
		for (Integer rawId : rawIds) {
			rawIdStrs.add(String.valueOf(rawId));
		}
		String sql = "update user_comment set update_ts='" + currTs + "' where raw_id in (" + String.join(", ", rawIdStrs) + ")";
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateStatus(String[] rawIds, int status) {
		if (rawIds == null || rawIds.length == 0) {
			return;
		}

		String currTs = DateUtils.getCurrDateStr();
		StringBuilder sqlBuilder = new StringBuilder("update raw_data set status = ");
		sqlBuilder.append(status);
		sqlBuilder.append(", last_modify_time = '" + currTs);
		sqlBuilder.append("' where id in (");
		sqlBuilder.append(String.join(", ", rawIds));
		// sqlBuilder.deleteCharAt(sqlBuilder.length() -1);
		sqlBuilder.append(")");

		String sql = sqlBuilder.toString();
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateStatus(List<RawData> rawDataList, int status) {
		if (rawDataList == null || rawDataList.isEmpty()) {
			return;
		}

		String currTs = DateUtils.getCurrDateStr();
		StringBuilder sqlBuilder = new StringBuilder("update raw_data set status = ");
		sqlBuilder.append(status);
		sqlBuilder.append(", last_modify_time = '" + currTs);
		sqlBuilder.append("' where id in (");
		for (RawData rawData : rawDataList) {
			sqlBuilder.append(rawData.getId());
			sqlBuilder.append(",");
		}
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		sqlBuilder.append(")");

		String sql = sqlBuilder.toString();
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateStatusAndBucketId(RawData rawData, Integer bucketId) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set " + " status=" + rawData.getMergeOutDataModel().getStatus() + " , last_modify_time='" + currTs + "' " + " , bucket_id=" + bucketId + " where id=" + rawData.getId();
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateStatus(RawDataBase rawDataBase) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set " + "status=" + rawDataBase.status + " , last_modify_time='" + currTs + "' where id=" + rawDataBase.getId();
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateFetchCommentUpdateTs(Long rawId) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set comment_ts='" + currTs + "' where id=" + rawId;
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateIsFetchComment(Long rawId) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set is_fetch_comment=1,comment_ts='" + currTs + "' where id=" + rawId;
		log.info(sql);
		this.repostory.update(sql);
	}

	public void updateIsFetchComment(Long rawId, int fetchFlag) {
		String currTs = DateUtils.getCurrDateStr();
		String sql = "update raw_data set is_fetch_comment=" + fetchFlag + ",comment_ts='" + currTs + "' where id=" + rawId;
		log.info(sql);
		this.repostory.update(sql);
	}

	@Transactional
	public void updateIsFetchComment(Long rawId, int fetchFlag, String comment_ts) {
		String sql = "update raw_data set is_fetch_comment=" + fetchFlag + ",comment_ts='" + comment_ts + "' where id=" + rawId;
		log.info(sql);
		this.repostory.update(sql);
	}

	public List<RawData> findByResource(String resource) {
		String sql = "select * from raw_data where IdInfo_strSource = '" + resource + "'";
		List<Object[]> fields = this.repostory.query(sql);
		List<RawData> rawDatas = new ArrayList<RawData>();
		for (int i = 0; i < fields.size(); i++) {
			Object[] strs = fields.get(i);
			RawData rawData = this.createRawData(strs);
			rawDatas.add(rawData);
		}
		return rawDatas;
	}

	// TODO 废弃
	public List<RawData> findByCity(String city) {
		String sql = "select * from raw_data where IdInfo_strCity = " + city + " order by id desc";
		List<Object[]> fields = this.repostory.query(sql);
		List<RawData> rawDatas = new ArrayList<RawData>();
		for (int i = 0; i < fields.size(); i++) {
			Object[] strs = fields.get(i);
			RawData rawData = this.createRawData(strs);
			rawDatas.add(rawData);
		}
		return rawDatas;
	}
	public List<RawData> findByCityAndPlaceType(String city,String placeType) {
		String sql = "select * from raw_data where IdInfo_strCity ='" + city
				+ "' and IdInfo_strPlaceType='" + placeType + "'";
		List<Object[]> fields = this.repostory.query(sql);
		List<RawData> rawDatas = new ArrayList<RawData>();
		for (int i = 0; i < fields.size(); i++) {
			Object[] strs = fields.get(i);
			RawData rawData = this.createRawData(strs);
			rawDatas.add(rawData);
		}
		return rawDatas;
	}

	/**
	 * 分页查询人工处理的rawData
	 * 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<RawData> findMannulMergeRawData(int start, int pageSize) {
		String sql = "select * from raw_data where status = 5 order by id limit " + start + "," + pageSize;
		List<Object[]> fields = this.repostory.query(sql);
		List<RawData> rawDatas = new ArrayList<RawData>();
		for (int i = 0; i < fields.size(); i++) {
			Object[] strs = fields.get(i);
			RawData rawData = this.createRawData(strs);
			rawDatas.add(rawData);
		}
		return rawDatas;
	}

	public Integer getMaxRawId() {
		String sql = "select max(id) from raw_data";
		List<Integer> objsList = this.repostory.queryIntResult(sql);
		if (objsList.isEmpty()) {
			return 0;
		} else {
			return objsList.get(0);
		}
	}

	public List<RawData> getRawDataList(String sql, Integer currPage, int pageSize) {
		log.info("query:" + sql);
		List<RawData> rawDatas = new LinkedList<RawData>();
		List<Object[]> objects = repostory.getList(sql, currPage, pageSize);
		for (Object[] objs : objects) {
			RawData rd = createRawData(objs);
			rawDatas.add(rd);
		}
		return rawDatas;
	}

	public List<RawData> findByIdAndStatus(int startId, int endId, List<String> statusList) {
		String sql = "select * from raw_data where id >= " + startId + " and id < " + endId + " and status in ('" + String.join("', '", statusList) + "')";
		List<Object[]> fields = this.repostory.query(sql);
		List<RawData> rawDatas = new ArrayList<RawData>();
		for (Object[] strs : fields) {
			RawData rawData = this.createRawData(strs);
			rawDatas.add(rawData);
		}
		return rawDatas;
	}

	public Map<Integer, RawData> findByCityAndStatusIn(String city, List<String> statusList) {
		String sql = "select * from raw_data where IdInfo_strCity = '" + city + "' and status in (" + String.join(", ", statusList) + ")";
		List<Object[]> fields = this.repostory.query(sql);
		Map<Integer, RawData> resultMap = new HashMap<Integer, RawData>(fields.size());
		for (Object[] strs : fields) {
			RawData rawData = this.createRawData(strs);
			resultMap.put(rawData.getId(), rawData);
		}
		return resultMap;
	}

	public void updateRawDataBaseStatus(List<RawDataBase> rawDataList, int status) {
		if (rawDataList == null || rawDataList.isEmpty()) {
			return;
		}

		String currTs = DateUtils.getCurrDateStr();
		StringBuilder sqlBuilder = new StringBuilder("update raw_data set status = ");
		sqlBuilder.append(status);
		sqlBuilder.append(", last_modify_time = '" + currTs);
		sqlBuilder.append("' where id in (");
		for (RawDataBase rawData : rawDataList) {
			sqlBuilder.append(rawData.getId());
			sqlBuilder.append(",");
		}
		sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
		sqlBuilder.append(")");

		String sql = sqlBuilder.toString();
		log.info(sql);
		this.repostory.update(sql);
	}

	public List<String> findRawIdByStatusIn(String... statuses) {
		if (statuses.length == 0) {
			return new ArrayList<String>();
		}

		List<String> rawDataList = new ArrayList<String>();
		String sql = "select id from raw_data where status in (" + String.join(", ", statuses) + ")";
		List<Integer> fields = this.repostory.queryIntResult(sql);
		for (Integer id : fields) {
			rawDataList.add(String.valueOf(id));
		}
		return rawDataList;
	}

	public List<RawDataBase> findIdAndUrlBySourceAndType(String source, String type) {
		String sql = "select id, IdInfo_strUrl, status from raw_data where IdInfo_strSource = '" + source + "' and IdInfo_strPlaceType = '" + type + "'";
		List<Object[]> objsList = this.repostory.query(sql);
		List<RawDataBase> rawDataList = new ArrayList<RawDataBase>();
		for (Object[] objs : objsList) {
			try {
				RawDataBase rawData = new RawDataBase();
				rawData.setId(((Number) objs[0]).intValue());
				rawData.idInfo.strURL = (String) objs[1];
				rawData.status = Integer.parseInt((String) objs[2]);
				rawDataList.add(rawData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rawDataList;
	}

	public List<RawDataBase> findRawIdAndIdInfoIdByType(String source, String type) {
		String sql = "select id, IdInfo_strId from raw_data where IdInfo_strSource = '" + source + "' and IdInfo_strPlaceType = '" + type + "'";
		List<Object[]> objsList = this.repostory.query(sql);
		List<RawDataBase> rawDataList = new ArrayList<RawDataBase>();
		for (Object[] objs : objsList) {
			try {
				RawDataBase rawData = new RawDataBase();
				rawData.setId(((Number) objs[0]).intValue());
				rawData.idInfo.strId = (String) objs[1];
				rawDataList.add(rawData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rawDataList;
	}

	public List<Integer> findIdListByType(String type) {
		String sql = "select id from raw_data where IdInfo_strPlaceType = '" + type + "'";
		return this.repostory.queryIntResult(sql);
	}

	public List<RawDataBase> findIdUrlByStrIdList(List<String> strIdList){
		String sql = "select id, IdInfo_strId, PlaceInfo_strLng, PlaceInfo_strLat from raw_data where IdInfo_strId in ('" + String.join("','", strIdList) + "')";
		List<Object[]> objsList = this.repostory.query(sql);
		List<RawDataBase> rawDataList = new ArrayList<RawDataBase>();
		for (Object[] objs : objsList) {
			try {
				RawDataBase rawData = new RawDataBase();
				rawData.setId(((Number) objs[0]).intValue());
				rawData.idInfo.strId = (String) objs[1];
				rawData.placeInfo.strLng = (String) (objs[2] == null ? "" : objs[2]);
				rawData.placeInfo.strLat = (String) (objs[3] == null ? "" : objs[3]);
				rawDataList.add(rawData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rawDataList;
	}
	
	public List<RawDataBase> findIdUrlByUrlList(List<String> urlList) {
		String sql = "select id, IdInfo_strUrl, PlaceInfo_strLng, PlaceInfo_strLat from raw_data where IdInfo_strUrl in ('" + String.join("','", urlList) + "')";
		List<Object[]> objsList = this.repostory.query(sql);
		List<RawDataBase> rawDataList = new ArrayList<RawDataBase>();
		for (Object[] objs : objsList) {
			try {
				RawDataBase rawData = new RawDataBase();
				rawData.setId(((Number) objs[0]).intValue());
				rawData.idInfo.strURL = (String) objs[1];
				rawData.placeInfo.strLng = (String) (objs[2] == null ? "" : objs[2]);
				rawData.placeInfo.strLat = (String) (objs[3] == null ? "" : objs[3]);
				rawDataList.add(rawData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rawDataList;
	}
	
	/**
	 * 根据来源查找top元素
	 * @param source 数据源
	 * @param topNum top元素
	 * @return
	 */
	public List<RawData> findTopItems(String source, int topNum) {
		String sql = "select * from raw_data where idinfo_strSource='"+source+"' "
				+ "where PlaceInfo_strName!='' and PlaceInfo_strName is not null "
				+ "order by PopularInfo_strRateCount desc limit "+topNum;
		List<RawData> resultList = new ArrayList<RawData>();
		List<Object[]> objsList = this.repostory.query(sql);
		for (Object[] objects : objsList) {
			RawData rd = this.createRawData(objects);
			resultList.add(rd);
		}
		return resultList;
	}

	public List<RawDataBase> findLatLngByIdIn(List<String> daodaoRawIdList) {
		String sql = "select id, PlaceInfo_strLng, PlaceInfo_strLat from raw_data where id in (" + String.join(",", daodaoRawIdList) + ")";
		List<Object[]> objsList = this.repostory.query(sql);
		List<RawDataBase> rawDataList = new ArrayList<RawDataBase>();
		for (Object[] objs : objsList) {
			try {
				RawDataBase rawData = new RawDataBase();
				rawData.setId(((Number) objs[0]).intValue());
				rawData.placeInfo.strLng = (String) (objs[1] == null ? "" : objs[1]);
				rawData.placeInfo.strLat = (String) (objs[2] == null ? "" : objs[2]);
				rawDataList.add(rawData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rawDataList;
	}
}
