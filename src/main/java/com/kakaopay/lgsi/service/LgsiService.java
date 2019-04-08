package com.kakaopay.lgsi.service;

import java.util.Iterator;
import java.util.List;

import com.kakaopay.lgsi.entity.LocalGoverment;
import com.kakaopay.lgsi.entity.LocalGovermentSupport;

public interface LgsiService {
	String saveAndUpdateLgsiFromCSV(Iterator<String[]> csvRowIterator) throws Exception;
	List<LocalGovermentSupport> getLgsiSupportAllInformation() throws Exception;
	List<LocalGovermentSupport> getLgsiSupportInformationByRegion(String region) throws Exception;
	List<LocalGovermentSupport> getLgsiInformationOrderByLimit(int limit) throws Exception;
	List<LocalGovermentSupport> getLgsiInformationLowestRate() throws Exception;
}
