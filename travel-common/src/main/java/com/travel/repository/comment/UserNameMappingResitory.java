package com.travel.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.comment.UserNameMapping;

@Repository
public interface UserNameMappingResitory extends
		JpaRepository<UserNameMapping, Long>, JpaSpecificationExecutor<UserNameMapping> {

}
