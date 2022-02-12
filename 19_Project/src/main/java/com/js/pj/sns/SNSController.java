package com.js.pj.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.js.pj.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		
		sDAO.getMsg(1, req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "sns/sns.jsp");
		
		return "index";
		
	}	
}
