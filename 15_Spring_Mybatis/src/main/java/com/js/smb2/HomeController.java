package com.js.smb2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDAO pDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		pDAO.getAllProduct(req);
		
		return "index";
	}
	
	@RequestMapping(value = "/product.del.do", method = RequestMethod.GET)
	public String delProduct(Product p, HttpServletRequest req) {
		
		pDAO.delProduct(p, req);
		pDAO.getAllProduct(req);
		
		return "index";
	}
	
	@RequestMapping(value = "/product.reg.do", method = RequestMethod.POST)
	public String regProduct(Product p, HttpServletRequest req) {
		
		pDAO.regProduct(p, req);
		pDAO.getAllProduct(req);
		
		return "index";
	}
	
	@RequestMapping(value = "/product.searchName.do", method = RequestMethod.GET)
	public String searchName(Product p, HttpServletRequest req) {

		pDAO.searchName(p, req);
		
		return "index";
	}
	
	@RequestMapping(value = "/product.getPrice.do", method = RequestMethod.GET)
	public String getPrice(Product p, HttpServletRequest req) {

		pDAO.searchPrice(p, req);
		
		return "index";
	}
	
	@RequestMapping(value = "/product.getPriceToPrice.do", method = RequestMethod.GET)
	public String getPriceToPrice(HttpServletRequest req) {

		pDAO.searchPriceToPrice(req);
		
		return "index";
	}
	
	@RequestMapping(value = "/product.updatePrice.do", method = RequestMethod.GET)
	public String updatePrice(HttpServletRequest req) {
		
		pDAO.updatePrice(req);
		pDAO.getAllProduct(req);
	
		return "index";
	}
	
	
}
