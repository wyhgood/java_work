package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.travel.entity.RawIdLink;

@Repository
public interface RawIdLinkRepository extends JpaRepository<RawIdLink, Long>, JpaSpecificationExecutor<RawIdLink> {
}
