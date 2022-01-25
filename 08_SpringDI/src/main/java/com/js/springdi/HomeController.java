package com.js.springdi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "input";
	}
	
	@RequestMapping(value="calc.do")
	public String doCalc(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		System.out.println(x + y);
		
		return "input";
	}
	
}
