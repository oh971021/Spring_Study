package com.js.springmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP 에서의 Controller : Servlet 만들어서 사용
// doGet
// doPost
// IP주소/프로젝트명/컨틀롤러명? ...

// Spring 에서의 Controller : 일반 class 만들어서 어노테이션 사용 (@Controller)
// doGet, doPost : 일반 메소드 생성 후 요청에 따라 매핑 (@RequestMapping(value=""))로 매핑
// IP주소/top-level(패키지)끝자리/개발자가정의

@Controller				// Spring이 Controller로 인식한다.
public class HC {
	
	@RequestMapping(value="/")
	public String goIndex() {
		
		// forward로 항상 엔딩을 쳤는데, 이걸 짧게 정리 해놓음.
		// 메소드 반환을 String 으로 한다.
		return "index";	// index.jsp로 forwarding 해준다.
	}
	
	@RequestMapping(value="index.go")
	public String ggggggg() {
		System.out.println("index.go로 요청받음");
		return "index";
	}
	
	@RequestMapping(value="index.do")
	public String fffffff() {
		System.out.println("index.do로 요청받음");
		return "index";
	}
	
	// top-level/t - get요청하면 콘솔에 ttt출력
	@RequestMapping(value="t")
	public String tttttt() {
		System.out.println("ttt");
		return "index";
	}
	
	@RequestMapping(value="h")
	public void hhhhh() {
		System.out.println("html 이동");
		// return "index.html";
	}
	
	// top-level/b - get요청하면 콘솔에 bbb출력
	@RequestMapping(value="b", method=RequestMethod.GET)
	public String bbbbbb() {
		System.out.println("bbb");
		return "index";
	}	
	
	
}
