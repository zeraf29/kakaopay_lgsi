package com.kakaopay.lgsi.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;


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
	private static String csvFileName = "/src/main/resources/static/2019경력공채_개발_사전과제1_지자체협약지원API개발_v.1.csv";
	
	@RequestMapping(value = "/insert/csv", method = RequestMethod.GET)
	public void insertCsv() {
		try {
			InputStreamReader is = new InputStreamReader(new FileInputStream(csvFileName), "EUC-KR");
	         CSVReader reader = new CSVReader(is, ',', '"', 0);
	         List<String[]> list = reader.readAll();
	         
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
