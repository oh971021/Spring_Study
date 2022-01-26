package com.js.smb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private MDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value = "/menu.show", method = RequestMethod.GET)
	public String getAllMenu(HttpServletRequest req) {
		// 모델
			// select
		mDAO.getAllMenu(req);
		
		// 가고 싶은 목적지
		return "select";
	}
	
	@RequestMapping(value = "/menu.reg.go", method = RequestMethod.GET)
	public String regMenu(HttpServletRequest req) {
			
		// 가고 싶은 목적지
		return "insert";
	}
	
	@RequestMapping(value = "/menu.reg.do", method = RequestMethod.GET)
	public String regMenuDo(Menu m, HttpServletRequest req) {
		// 모델
			// insert
		mDAO.regMenu(m, req);
		mDAO.getAllMenu(req);
		
		// 가고 싶은 목적지
		return "select";
	}
	
	
	
}
