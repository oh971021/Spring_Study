package com.js.pj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.js.pj.sns.SNSDAO;

@Controller
public class HomeController {

	@Autowired
	private SNSDAO sDAO;
	
	private boolean firstReq;
	
	public HomeController() {	// 페이지를 처음 열었을 때 여기를 거쳐감
		firstReq = true;
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		
		if(firstReq) {	// 맨 처음 실행 됐을 때만 게시판 수를 읽어준다.
			sDAO.getAllMsgCount();			
			firstReq = false;	// 한번 사용하고, false로 바꿔줌으로써 다음 요청들은 무시하도록 한다.
		}
		
		req.setAttribute("loginPage", "member/login.jsp");
		req.setAttribute("contentPage", "home.jsp");
		
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		
		// 컨트롤러 내에서 같은 메소드를 호출할 수 있다.
		return home(req);
	}
	
}
