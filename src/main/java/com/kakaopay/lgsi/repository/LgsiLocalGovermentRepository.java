package com.kakaopay.lgsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakaopay.lgsi.entity.LocalGoverment;
import com.kakaopay.lgsi.entity.LocalGovermentSupport;

public interface LgsiLocalGovermentRepository extends JpaRepository<LocalGoverment,String>{

	List<LocalGoverment> findByLocalGovermentName(String localGovermentName);
	
}
