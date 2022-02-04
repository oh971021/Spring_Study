package com.js.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuildingController {
	
	@Autowired
	private BuildingDAO bDAO;
	
	@RequestMapping(value = "/shop.getxml", method = RequestMethod.GET,
					produces = "application/xml; charset=utf-8")
	public @ResponseBody Building getXML() {

		return bDAO.getAllshop();
		
	}
	
	@RequestMapping(value = "/shop.getjson", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Building getJSON() {
		// ResponseBody 결과를 바디에 뿌려주는 것 (return이 값이면 자동으로 응답을 해준다)
		
		// bDAO.getAllshop();	// Building이 return됨
		return bDAO.getAllshop();
		
	}
	
	@RequestMapping(value = "/shop.search", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Building shopSearch(FloorSeletor fs) {
		
		return bDAO.searchShop(fs); 		
	}
}
