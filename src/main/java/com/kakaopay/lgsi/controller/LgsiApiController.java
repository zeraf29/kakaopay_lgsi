package com.kakaopay.lgsi.controller;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody List<LocalGovermentSupport> getLgsiAllInformation(){
		List<LocalGovermentSupport> listLocalGovermentSupport = new ArrayList<LocalGovermentSupport>();
		try {
			listLocalGovermentSupport = lgsiService.getLgsiSupportAllInformation();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listLocalGovermentSupport;
	}
	
}
