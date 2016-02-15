package com.mtsmda.souvenir.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SouvenirController {
	
	@RequestMapping(value = "/souvenirInsert", method = RequestMethod.POST)
	public String get(HttpServletRequest request, @RequestParam("souvenirPath") MultipartFile file) {
		@SuppressWarnings("rawtypes")
		Map parameterMap = request.getParameterMap();
		System.out.println(parameterMap.size());
		System.out.println(file == null);
		System.out.println();
		return "";
	}

}
