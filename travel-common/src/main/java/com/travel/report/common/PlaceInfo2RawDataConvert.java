//package com.travel.report.common;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.function.Consumer;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.cedarsoftware.util.io.JsonWriter;
//import com.travel.data.UserComment;
//import com.travel.entity.HotelInfo;
//import com.travel.entity.IdInfo;
//import com.travel.entity.MallInfo;
//import com.travel.entity.PlaceInfo;
//import com.travel.entity.PopularInfo;
//import com.travel.entity.QualityInfo;
//import com.travel.entity.RawData;
//import com.travel.entity.RestaurantInfo;
//import com.travel.entity.ViewInfo;
//import com.travel.entity.mergeout.MergeOutDataModel;
//import com.travel.entity.report.PlaceAreaRelation;
//import com.travel.entity.report.PlaceInfoNew;
//import com.travel.entity.report.PlaceInfoPicture;
//import com.travel.repository.PlaceAreaRelationRepository;
//import com.travel.repository.PlaceInfoNewRepository;
//import com.travel.repository.PlaceInfoPictureRepository;
//import com.travel.repository.PlaceInfoRecommendRepository;
//import com.travel.repository.UgcCommentRepository;
//
//@Component
//public class PlaceInfo2RawDataConvert {
//	static final Log log = LogFactory.getLog(PlaceInfo2RawDataConvert.class);
//	@Autowired
//	private PlaceInfoNewRepository placeInfoNewRepo;
//	@Autowired
//	private PlaceInfoPictureRepository placeInfoPictureRepo;
//	@Autowired
//	private UgcCommentRepository ugcCommentRepository;
//	@Autowired
//	private PlaceInfoRecommendRepository placeInfoRecommendRepo;
//	@Autowired
//	private PlaceAreaRelationRepository placeAreaRelationRepo;
//	private RawData createIdInfo(PlaceInfoNew placeInfoNew,RawData rd){
//		IdInfo idInfo = new IdInfo();
//		rd.getMergeOutDataModel().setIdInfo(idInfo);
//		PlaceAreaRelation par = placeAreaRelationRepo.findOne(placeInfoNew.getCity());
//		if(par!=null){
//			idInfo.setIdInfo_strCity(par.getName());
//		}else{
//			log.warn("can't find city:"+placeInfoNew.getCity());
//		}
//		PlaceAreaRelation c = placeAreaRelationRepo.
//				findOne(placeInfoNew.getCountry());
//		
//		if(c!=null){
//			idInfo.setIdInfo_strCountry(c.getName());
//		}else{
//			log.warn("can't find city:"+placeInfoNew.getCountry());
//		}
//		
//		idInfo.setIdInfo_strPlaceType(PlaceType.
//				getById(placeInfoNew.getType()));
//		return rd;
//	}
//	private RawData createMallInfo(PlaceInfoNew placeInfoNew,RawData rd){
//		MallInfo mallInfo = new MallInfo();
//		rd.getMergeOutDataModel().setMailInfo(mallInfo);
//		return rd;
//	}
//	private RawData createPlaceInfo(PlaceInfoNew placeInfoNew,RawData rd){
//		PlaceInfo placeInfo = new PlaceInfo();
//		rd.getMergeOutDataModel().setPlaceInfo(placeInfo);
//		placeInfo.setPlaceInfo_listAliasName(placeInfoNew.getAlias());
//		//placeInfo.setPlaceInfo_listPics(placeInfo_listPics);
//		placeInfo.setPlaceInfo_listTelephone(placeInfoNew.getPhone());
//		placeInfo.setPlaceInfo_strAddress(placeInfoNew.getAddress());
//		placeInfo.setPlaceInfo_strCost(placeInfoNew.getCost().toString());
//		placeInfo.setPlaceInfo_strLat(placeInfoNew.getLatitude().toString());
//		placeInfo.setPlaceInfo_strLng(placeInfoNew.getLongitude().toString());
//		List<PlaceInfoPicture> mainPics = placeInfoPictureRepo
//				.findByPlaceid(placeInfoNew.getId());
//		if(!mainPics.isEmpty()){
//			placeInfo.setPlaceInfo_strMainPic(mainPics.get(0).getPicture());
//		}
//		placeInfo.setPlaceInfo_strName(placeInfoNew.getName());
//		placeInfo.setPlaceInfo_strDesc(placeInfoNew.getDescription());
//		placeInfo.setPlaceInfo_strOpenTime(placeInfoNew.getOpeningtime());
//		//placeInfo.setPlaceInfo_strTraffic(placeInfoNew.get);
//		return rd;
//	}
//	private RawData createHotelInfo(PlaceInfoNew placeInfoNew,RawData rd){
//		HotelInfo hotelInfo = new HotelInfo();
//		rd.getMergeOutDataModel().setHotelInfo(hotelInfo);
//		return rd;
//	}
//	private RawData createPopularInfo(PlaceInfoNew placeInfoNew,RawData rd){
//		PopularInfo popularInfo = new PopularInfo();
//		rd.getMergeOutDataModel().setPopularInfo(popularInfo);
//		//有一些ugcComment里的时间为0000-00-00 00:00:00这里转化成时间的时候会有问题
//		//List<UgcComment> comments = ugcCommentRepository
//		//		.findByPlaceid(placeInfoNew.getId());
//		List<UserComment> userComments = new LinkedList<UserComment>();
////		Integer rateCount = placeInfoNew.getScorenum();
//		Integer rateCount = placeInfoNew.getCommentnum();
//		//for(UgcComment c:comments){
//		for(int i=0;i<rateCount;i++){
//			UserComment uc = new UserComment();
//			//TODO construct usercomment
//			userComments.add(uc);
//		}
//		try{
//			String jsonComments = JsonWriter.objectToJson(userComments);
//			popularInfo.setPopularInfo_listUserComment(jsonComments);
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//		popularInfo.setPopularInfo_userCommentSize(placeInfoNew.getCommentnum());
//		popularInfo.setPopularInfo_strScore(placeInfoNew.getScore());
//		return rd;
//	}
//	private RawData createRestaurantInfo(PlaceInfoNew placeInfoNew,
//			RawData rd){
//		RestaurantInfo restaurantInfo = new RestaurantInfo();
//		rd.getMergeOutDataModel().setRestaurantInfo(restaurantInfo);
//		return rd;
//	}
//	private RawData createViewInfo(PlaceInfoNew placeInfoNew,
//			RawData rd){
//		ViewInfo viewInfo = new ViewInfo();
//		rd.getMergeOutDataModel().setViewInfo(viewInfo);
//		return rd;
//	}
//	public RawData createRawDataByPlaceInfoNewId(Long id){
//		PlaceInfoNew placeInfoNew = placeInfoNewRepo.findOne(id);
//		return convertPlaceInfoNew2RawData(placeInfoNew);
//	}
//	public RawData createQuality(PlaceInfoNew placeInfoNew,RawData rd){
//		rd.getMergeOutDataModel().setQuality(placeInfoNew.getQuality().doubleValue());
//		QualityInfo qualityInfo = new QualityInfo();
//		qualityInfo.setStarScore(placeInfoNew.getScore());
//		rd.getMergeOutDataModel().setQualityInfo(qualityInfo);
//		return rd;
//	}
//	public RawData convertPlaceInfoNew2RawData(PlaceInfoNew placeInfoNew){
//		RawData rd = new RawData();
//		rd.setMergedId(placeInfoNew.getMergeid().toString());
//		rd.setMergeOutDataModel(new MergeOutDataModel());
//		rd.setId(placeInfoNew.getId().intValue());
//		createIdInfo(placeInfoNew, rd);
//		createPlaceInfo(placeInfoNew, rd);
//		createMallInfo(placeInfoNew, rd);
//		createHotelInfo(placeInfoNew, rd);
//		createPopularInfo(placeInfoNew, rd);
//		createRestaurantInfo(placeInfoNew, rd);
//		createViewInfo(placeInfoNew, rd);
//		createQuality(placeInfoNew, rd);
//		return rd;
//	}
//	public List<RawData> convertPlaceInfoNew(List<PlaceInfoNew> placeInfoNews){
//		List<RawData> rawDatas = new LinkedList<RawData>();
//		final BlockingQueue<RawData> rds = new LinkedBlockingQueue<RawData>();
//		placeInfoNews.parallelStream().forEach(new Consumer<PlaceInfoNew>(){
//			@Override
//			public void accept(PlaceInfoNew t) {
//				try {
//					rds.put(convertPlaceInfoNew2RawData(t));
//				} catch (InterruptedException e) {
//					log.warn("exception",e);
//				}
//			}
//		});
////		for(PlaceInfoNew placeInfoNew:placeInfoNews){
////			rawDatas.add(convertPlaceInfoNew2RawData(placeInfoNew));
////		}
//		rawDatas.addAll(rds);
//		return rawDatas;
//	}
//}