package com.kakaopay.lgsi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaopay.lgsi.common.sortLimit;
import com.kakaopay.lgsi.entity.LocalGoverment;
import com.kakaopay.lgsi.entity.LocalGovermentSupport;
import com.kakaopay.lgsi.repository.LgsiLocalGovermentRepository;
import com.kakaopay.lgsi.repository.LgsiLocalGovermentSupportRepository;

@Service("lgsiServiceImpl")
public class LgsiServiceImpl implements LgsiService{
	
	@Autowired
	private LgsiLocalGovermentRepository lgsiLocalGovermentRepository;
	
	@Autowired
	private LgsiLocalGovermentSupportRepository lgsiLocalGovermentSupportRepository;

	@Override
	@Transactional
	public String saveAndUpdateLgsiFromCSV(Iterator<String[]> csvRowIterator) throws Exception {
		// TODO Auto-generated method stub
		String returnValue = "true";
		
		LocalGoverment localGoverment;
		LocalGovermentSupport localGovermentSupport;
		List<LocalGovermentSupport> listLocalGovermentSupport = new ArrayList<LocalGovermentSupport>();
		
		try {
			while(csvRowIterator.hasNext()) {
	        	String[] key = csvRowIterator.next();
	        	System.out.println("reg"+String.format("%04d", Integer.parseInt(key[0]))+":"+key[1]+":"+key[2]);
	        	
	        	//Init Entity
	        	localGoverment = new LocalGoverment();
	        	localGovermentSupport = new LocalGovermentSupport();
	        	
	        	//Insert LocalGoverment Table
	        	localGoverment.setRegion(key[1]);
	        	
	        	//Insert LocalGovermentSupport TablelocalGovermentSupport.setLocalGoverment(localGoverment);
	        	localGovermentSupport.setLocalGoverment(localGoverment);
	        	localGovermentSupport.setTarget(key[2]);
	        	localGovermentSupport.setUsage(key[3]);
	        	localGovermentSupport.setLimit(key[4]);
	        	localGovermentSupport.setRate(key[5]);
	        	localGovermentSupport.setInstitute(key[6]);
	        	localGovermentSupport.setMgmt(key[7]);
	        	localGovermentSupport.setReception(key[8]);
	        	localGovermentSupport.setRegDate(new Date());
	        	localGovermentSupport.setModDate(new Date());
	        	listLocalGovermentSupport.add(localGovermentSupport);
	        	
	        	
	        }
			lgsiLocalGovermentSupportRepository.saveAll(listLocalGovermentSupport);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			returnValue = "false";
		}
		return returnValue;
	}
	
	@Override
	public List<LocalGovermentSupport> getLgsiSupportAllInformation() throws Exception {
		List<LocalGovermentSupport> listLocalGovermentSupport = lgsiLocalGovermentSupportRepository.findAll();
		return listLocalGovermentSupport;
	}
	
	@Override
	public List<LocalGovermentSupport> getLgsiSupportInformationByRegion(String region) throws Exception {
		List<LocalGovermentSupport> listLocalGovermentSupport = lgsiLocalGovermentSupportRepository.findByRegion(region);
		return listLocalGovermentSupport;
	}

	@Override
	public List<LocalGovermentSupport> getLgsiInformationOrderByLimit(int limit) throws Exception {
		List<LocalGovermentSupport> listLocalGovermentSupport = lgsiLocalGovermentSupportRepository.findAll();
		Collections.sort(listLocalGovermentSupport, new sortLimit());
		listLocalGovermentSupport = listLocalGovermentSupport.subList(0, limit);
		return listLocalGovermentSupport;
	}
	
	@Override
	public List<LocalGovermentSupport> getLgsiInformationLowestRate() throws Exception {
		List<LocalGovermentSupport> listLocalGovermentSupport = lgsiLocalGovermentSupportRepository.findAll();
		listLocalGovermentSupport = listLocalGovermentSupport.subList(0, 1);
		return listLocalGovermentSupport;
	}
	
	@Override
	public LocalGovermentSupport updateLocalGovermentSupport(LocalGovermentSupport localGovermentSupport) throws Exception {
		LocalGovermentSupport localGovermentSupportTarget = lgsiLocalGovermentSupportRepository.findByIdx(localGovermentSupport.getIdx());
		
		localGovermentSupportTarget.setInstitute(localGovermentSupport.getInstitute());
		localGovermentSupportTarget.setLimit(localGovermentSupport.getLimit());
		localGovermentSupportTarget.setMgmt(localGovermentSupport.getMgmt());
		localGovermentSupportTarget.setRate(localGovermentSupport.getRate());
		localGovermentSupportTarget.setReception(localGovermentSupport.getReception());
		localGovermentSupportTarget.setTarget(localGovermentSupport.getTarget());
		localGovermentSupportTarget.setUsage(localGovermentSupport.getUsage());
		localGovermentSupportTarget.setLocalGoverment(localGovermentSupport.getLocalGoverment());
		
		return lgsiLocalGovermentSupportRepository.save(localGovermentSupport);
	}
	
}
