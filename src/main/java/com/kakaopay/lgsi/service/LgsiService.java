package com.kakaopay.lgsi.service;

import java.util.Iterator;
import java.util.List;

import com.kakaopay.lgsi.entity.LocalGoverment;
import com.kakaopay.lgsi.entity.LocalGovermentSupport;

public interface LgsiService {
	String saveAndUpdateLgsiFromCSV(Iterator<String[]> csvRowIterator) throws Exception;
	List<LocalGovermentSupport> getLgsiSupportAllInformation() throws Exception;
	List<LocalGoverment> getLgsiSupportInformationByLocalGovermentName(String localGovermentName) throws Exception;
}
