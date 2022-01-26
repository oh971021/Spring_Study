package com.js.springmvc4;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "input";
	}
	
	@RequestMapping(value = "/record.show", method = RequestMethod.POST)
	public String record(StudentDTO sDTO, HttpServletRequest req) {
		dao.calc(sDTO, req);
		
		return "output";
	}
	
	
}
