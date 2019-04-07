package com.kakaopay.lgsi.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


@Controller
@RequestMapping("/web")
public class LgsiWebController {

	
	@RequestMapping(value = "/web/main", method = RequestMethod.GET)
	public @ResponseBody String main() throws Exception {
		String result = "Hello";
		
        //System.out.println(data);
		return result;
    }
	
	//local csv data file location
	private static String csvFileName = "/src/main/resources/static/2019경력공채_서버개발_사전과제1_지자체협약지원정보_16년12월현재__최종.csv";
	@RequestMapping(value = "/insert/csv/local", method = RequestMethod.GET)
	public void insertCsvFromLocal() {
		try {
			ClassPathResource cpr = new ClassPathResource(csvFileName);
			InputStreamReader is = new InputStreamReader(new FileInputStream(cpr.getPath()), "EUC-KR");
	        Iterator<String[]> csvRowIterator = new CSVReaderBuilder(is)
	        						.withCSVParser(
	        								new CSVParserBuilder()
	        								.withSeparator(',')
	        								.build()
	        						).withSkipLines(1).build().iterator();
	        int index = 0;
	        while(csvRowIterator.hasNext()) {
	        	String[] key = csvRowIterator.next();
	        	System.out.println(index+":"+key[0]+":"+key[1]+":"+key[2]);
	        	index++;
	        }
	        
	        is.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
