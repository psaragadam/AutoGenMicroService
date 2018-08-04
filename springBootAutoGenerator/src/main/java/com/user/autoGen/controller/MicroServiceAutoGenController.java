package com.user.autoGen.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.autoGen.model.AutoGenerateRequest;
import com.user.autoGen.service.AutoGeneratorService;

@Controller
@RequestMapping("/autoGen")
public class MicroServiceAutoGenController {

	@Autowired
	AutoGeneratorService autoGeneratorService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String createUC() {
		return "home";
	}
	
	@RequestMapping(value = "/newService", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public String createUC(@RequestBody AutoGenerateRequest autoGenerateRequest, HttpServletResponse response) {
		autoGeneratorService.generateService(autoGenerateRequest, response);
		return "success";
	}

}
