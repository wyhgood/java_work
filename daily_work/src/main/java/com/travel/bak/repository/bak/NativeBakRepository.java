package com.travel.bak.repository.bak;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.travel.entity.RawData;
import com.travel.entity.report.PlaceInfoNew;


@Component("nativeRepositoryBak")
@Transactional
public class NativeBakRepository implements InitializingBean,ApplicationContextAware{
	Logger log = LoggerFactory.getLogger(NativeBakRepository.class);
//	@PersistenceContext
//	private EntityManager em;
	@Resource(name="entityManagerFactoryBak")
	private EntityManagerFactory emf;
	@SuppressWarnings("unchecked")
	public List<Object[]> query(String sql){
		log.info("query:"+sql);
		EntityManager em = emf.createEntityManager();
		try {
			List<Object[]> list = (List<Object[]>)em.createNativeQuery(sql)
					.getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Integer> queryIntResult(String sql){
		log.info("query:"+sql);
		EntityManager em = emf.createEntityManager();
		try {
			List<Integer> list = (List<Integer>)em.createNativeQuery(sql)
					.getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<String> queryStringResult(String sql){
		log.info("query:"+sql);
		EntityManager em = emf.createEntityManager();
		try {
			List<String> list = (List<String>)em.createNativeQuery(sql)
					.getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@Transactional
	public void update(String sql){
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.createNativeQuery(sql).executeUpdate();
		}finally{
			em.getTransaction().commit();
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object[] findOne(String sql){
		EntityManager em = emf.createEntityManager();
		try {
			List<Object[]> results = (List<Object[]>)em.createNativeQuery(sql)
					.getResultList();
			if(results.size()==1){
				return results.get(0);
			}
			return null;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getList(String sql,Integer currPage,int pageSize){
		int start = (currPage-1)*pageSize;
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNativeQuery(sql);
			List<Object[]>  result = query.setMaxResults(pageSize)
					.setFirstResult(start)
					.getResultList();
			return result;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<RawData> getList(Integer currPage,int pageSize){
		int start = (currPage-1)*pageSize;
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("select rd from raw_data_mergeout rd "
					+ "order by rd.id asc");
			List<RawData> list = query.setMaxResults(pageSize)
					.setFirstResult(start).getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<RawData> getHighQuality(Integer currPage,int pageSize,double quality){
		int start = (currPage-1)*pageSize;
		String sql = "select rd from raw_data_mergeout rd"
				+ " where rd.quality>="+quality
				+ " order by rd.id asc";
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery(sql);
			List<RawData> list = query.setMaxResults(pageSize)
					.setFirstResult(start).getResultList();
			log.info("query:"+sql);
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<PlaceInfoNew> getPlaceInfoNewByPage(Integer currPage,
			int pageSize){
		int start = (currPage-1)*pageSize;
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("select pin from place_info pin "
					+ "order by pin.id asc");
			List<PlaceInfoNew> list = query.setMaxResults(pageSize)
					.setFirstResult(start).getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<PlaceInfoNew> getPlaceInfoNewByPage(Integer currPage,
			int pageSize,Integer cityId){
		int start = (currPage-1)*pageSize;
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("select pin from place_info pin "
					+ "where city="+cityId
					+ " order by pin.id asc");
			List<PlaceInfoNew> list = query.setMaxResults(pageSize)
					.setFirstResult(start).getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<RawData> getList(Integer currPage,int pageSize,String city){
		int start = (currPage-1)*pageSize;
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("select rd from raw_data_mergeout "
					+ "rd where rd.idInfo.IdInfo_strCity='"+city+"' "
					+ "order by rd.id asc");
			List<RawData> list = query.setMaxResults(pageSize)
					.setFirstResult(start).getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<RawData> getList(Integer currPage,int pageSize,
			String city,String placeType){
		int start = (currPage-1)*pageSize;
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("select rd from raw_data_mergeout "
					+ "rd where rd.idInfo.IdInfo_strCity='"+city+"' "
					+ " and rd.idInfo.IdInfo_strPlaceType='"+placeType+"' "
					+ "order by rd.id asc");
			List<RawData> list = query.setMaxResults(pageSize)
					.setFirstResult(start).getResultList();
			return list;
		}finally{
			em.close();
		}
	}
	@SuppressWarnings("unchecked")
	public Integer getCount(String sql){
		EntityManager em = emf.createEntityManager();
		try{
			List<BigInteger> results = em.createNativeQuery(sql).getResultList();
			return results.get(0).intValue();
		}finally{
			em.close();
		}
	}
	public void afterPropertiesSet() throws Exception {
		
		// TODO Auto-generated method stub
		//em = this.emf.createEntityManager();
//		emf = (EntityManagerFactory)context.getBean("entityManagerFactory");
	}
	private ApplicationContext context;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
}
