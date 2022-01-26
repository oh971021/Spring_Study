package com.js.springmvc2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "input";
	}
	
	// 1) JSP 방법
//	@RequestMapping(value="calc.do")
//	public String doCalcJSP(HttpServletRequest request) {
//		int x = Integer.parseInt(request.getParameter("x"));
//		int y = Integer.parseInt(request.getParameter("y"));
//		
//		System.out.println(x + y);
//		
//		return "input";
//	}
	
	// 2) Spring 방법
//	@RequestMapping(value="calc.do")
//	public String doCalcSpring(@RequestParam(value="x") int x, @RequestParam(value="y") int y) {
//		System.out.println(x * y);
//		return "input";
//	}
	
	// 3) Spring 스타일 (객체지향) - 최종형태
	@RequestMapping(value="calc.do")
	public String doCalcSpring(Data d) {
		
		// 빈으로 활용하려면 parameter의 name과 bean의 field name이 같아야 한다
		System.out.println(d.getX() + d.getY());
		
		return "input";
	}
	
	// ########### TEST ############ //
	
	// item.puchase - url
		// 콘솔에 입력받은 price, count 값 나오도록 출력
		// Data bean 사용 x, 새로 만들어서 작업
	// Model 생성해서 작업
	@RequestMapping(value="item.puchase")
	public String purchase(Data2 d, Model model) {
		Calc.mul(d, model);

		return "output";
	}
	
	// 11_SpringMVC
	
	// v = x,y 입력 받고 버튼 누르면
	// calc.do
	// 모델(M)거쳐서 결과 페이지에 +,- 결과 값 출력
	
	@RequestMapping(value="calc.do2")
	public String calcdo(Data3 d, Model m) {
		Calc.add(d, m);
		
		return "output";
	}
	
}
