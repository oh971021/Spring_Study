package com.js.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index2";
	}
	
	@RequestMapping(value = "/menu.get.json", method = RequestMethod.GET, 
			produces="application/json; charset=utf-8")
	public @ResponseBody Menus menuJSON() {
			// Body에 뿌려준다 menu 데이터들을 JSON 형식으로
		
		// new Menus()와 같음
		Menus mm = mDAO.getAllMenu(); // Menu를 가지고 있는 Menus가 됨
		return mm;
	}

	@RequestMapping(value = "/menu.get.xml", method = RequestMethod.GET, 
			produces="application/xml; charset=utf-8")
	public @ResponseBody Menus menuXML() {
		
		// new Menus()와 같음
		Menus mm = mDAO.getAllMenu(); // Menu를 가지고 있는 Menus가 됨
		return mm;
	}
	
	@RequestMapping(value = "/menu.get.json.name", method = RequestMethod.GET, 
			produces="application/json; charset=utf-8")
	public @ResponseBody Menus getMenuJSONByName(Menu m) {
	
		Menus mm = mDAO.getMenuJSONByName(m);
		return mm;
	}
	
	
}
