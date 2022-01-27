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
	
	@RequestMapping(value="/menu.del.do", method = RequestMethod.GET)
	public String delMenuDo(Menu m, HttpServletRequest req) {
		
		mDAO.delMenu(m, req);
		mDAO.getAllMenu(req);
		
		return "select";
	}
	
	@RequestMapping(value="/menu.update.do", method = RequestMethod.GET)
	public String updateMenu(Menu m, HttpServletRequest req) {
		
		mDAO.updateMenu(m, req);
		mDAO.getAllMenu(req);
		
		return "select";
	}
	
	@RequestMapping(value="/menu.modi.go", method = RequestMethod.GET)
	public String domiMenuGo() {
		
		return "update";
	}
	
	@RequestMapping(value="/menu.modi.do", method = RequestMethod.GET)
	public String domiMenuDO(Menu m, HttpServletRequest req) {

		mDAO.updateMenu(m, req);
		mDAO.getAllMenu(req);
		
		return "select";
	}
	
	@RequestMapping(value="/menu.detail.go", method = RequestMethod.GET)
	public String detailGo(Menu m, HttpServletRequest req) {
		
		mDAO.getMenu(m, req);
		
		return "detail";
	}
}
