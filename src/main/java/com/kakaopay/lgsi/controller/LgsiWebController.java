package com.kakaopay.lgsi.controller;

import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LgsiWebController {

	
	@RequestMapping(value = "/web/main", method = RequestMethod.GET)
	public @ResponseBody String main() throws Exception {
		String result = "Hello";
		
        //System.out.println(data);
		return result;
    }
}
