package com.kakaopay.lgsi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kakaopay.lgsi.entity.LocalGoverment;
import com.kakaopay.lgsi.entity.LocalGovermentSupport;

public interface LgsiLocalGovermentSupportRepository extends JpaRepository<LocalGovermentSupport,Long> {
	
	@Query(value = "SELECT l.region, s.target, s.usage, s.limit, s.rate, s.institute, s.mgmt, s.reception FROM  LocalGovermentSupport s, LocalGoverment l WHERE s.localGoverment = l.localGovermentCode AND l.region LIKE :region")
	List<LocalGovermentSupport> findByRegion(@Param("region") String region);

}
