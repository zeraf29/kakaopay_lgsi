package com.kakaopay.lgsi.controller;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.lgsi.entity.LocalGoverment;
import com.kakaopay.lgsi.entity.LocalGovermentSupport;
import com.kakaopay.lgsi.service.LgsiService;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

@RestController
@RequestMapping("/api")
public class LgsiApiController {

	@Autowired
	private LgsiService lgsiService;
	
	//local csv data file location
	private static String csvFileName = "/src/main/resources/static/2019경력공채_서버개발_사전과제1_지자체협약지원정보_16년12월현재__최종.csv";
	@RequestMapping(value = "/insert/csv/local", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> insertCsvFromLocal() {
		Map<String, String> rMap = new HashMap<String, String>();
		try {
			ClassPathResource cpr = new ClassPathResource(csvFileName);
			InputStreamReader is = new InputStreamReader(new FileInputStream(cpr.getPath()), "EUC-KR");
			Iterator<String[]> csvRowIterator = new CSVReaderBuilder(is)
	        						.withCSVParser(
	        								new CSVParserBuilder()
	        								.withSeparator(',')
	        								.build()
	        						).withSkipLines(1).build().iterator();
	       
			rMap.put("result", lgsiService.saveAndUpdateLgsiFromCSV(csvRowIterator));
			is.close();
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rMap;
	}
	
	
	//Get List local goverment support All information
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public @ResponseBody List<LocalGovermentSupport> getLgsiAllInformation(){
		List<LocalGovermentSupport> listLocalGovermentSupport = new ArrayList<LocalGovermentSupport>();
		try {
			listLocalGovermentSupport = lgsiService.getLgsiSupportAllInformation();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listLocalGovermentSupport;
	}
	
	//Get List local goverment support information by localGovermentName
	@RequestMapping(value = "/get/target/{region}", method = RequestMethod.GET)
	public @ResponseBody List<LocalGovermentSupport> getLgsiInformationByRegion(@PathVariable("region") String region){
		List<LocalGovermentSupport> listLocalGovermentSupport = new ArrayList<LocalGovermentSupport>();
		try {
			listLocalGovermentSupport = lgsiService.getLgsiSupportInformationByRegion(region);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listLocalGovermentSupport;
	}	
	
	//Get List local goverment support information about High limit
	@RequestMapping(value = "/get/limit/{limit}", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> getLgsiInformationOrderByLimit(@PathVariable(name="limit", required = false) String limit){
		int limitCnt = Integer.parseInt((StringUtils.isEmpty(limit) ? "0" : limit));
		List<LocalGovermentSupport> listLocalGovermentSupport = new ArrayList<LocalGovermentSupport>();
		Map<String, String> rMap = new HashMap<String, String>();
		String rString = "";
		try {
			listLocalGovermentSupport = lgsiService.getLgsiInformationOrderByLimit(limitCnt);
			for(LocalGovermentSupport temp : listLocalGovermentSupport) {
				rString += temp.getLocalGoverment().getRegion()+",";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		rMap.put("result", rString);
		return rMap;
	}
	
	//Get List local goverment support information about Low rate
	@RequestMapping(value = "/get/rate", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> getLgsiInformationLowLimit(){
		List<LocalGovermentSupport> listLocalGovermentSupport = new ArrayList<LocalGovermentSupport>();
		Map<String, String> rMap = new HashMap<String, String>();
		String rString = "";
		try {
			listLocalGovermentSupport = lgsiService.getLgsiInformationLowestRate();
			rString += listLocalGovermentSupport.get(0).getLocalGoverment().getRegion();
		}catch(Exception e) {
			e.printStackTrace();
		}
		rMap.put("result", rString);
		return rMap;
	}
}
