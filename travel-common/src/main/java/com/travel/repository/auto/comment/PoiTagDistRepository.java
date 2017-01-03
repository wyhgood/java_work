package com.travel.repository.auto.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.auto.comment.PoiTagDist;
@Repository
public interface PoiTagDistRepository extends
		JpaRepository<PoiTagDist, Integer>,
		JpaSpecificationExecutor<PoiTagDist> {

	public List<PoiTagDist> findByRawIdAndTagAndPolarity(Integer rawId,
			String tag, Integer polarity);
	public List<PoiTagDist> findByRawIdAndTag(Integer rawId,
			String tag);
}
