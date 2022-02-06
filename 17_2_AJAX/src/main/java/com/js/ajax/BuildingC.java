package com.js.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuildingC {
	
	@Autowired	// 객체 정보 자동 매핑 : 있으면 땡겨줌
	private BuildingDAO bDAO;
	
							// 이 링크를 들어가면 JSON 형식의 파일을 열어준다.
	@RequestMapping(value = "/shop.getjson", method = RequestMethod.GET, 
			produces="application/json; charset=utf-8") // 프로더시스 : 응답 시 반응할 데이터 형식 (현재는 제이슨으로 파일을 뿌려준다)
	public @ResponseBody Building getJson() {
		// 리스폰스바디 : 바디에 응답해준다. (파일 자체를 바디에 뿌려줌)
		return bDAO.getAllShop(); // 가게들을 가지고 있는 빌딩
	}
	
	@RequestMapping(value = "/shop.getxml", method = RequestMethod.GET, 
			produces="application/xml; charset=utf-8") // 프로더시스 : 응답 시 반응할 데이터 형식 (현재는 엑스엠엘으로 파일을 뿌려준다)
	public @ResponseBody Building getXML() {
		// 리스폰스바디 : 바디에 응답해준다. (파일 자체를 바디에 뿌려줌)
		return bDAO.getAllShop(); // 가게들을 가지고 있는 빌딩
	}
	
	@RequestMapping(value = "/shop.search", method = RequestMethod.GET, 
			produces="application/json; charset=utf-8") // 프로더시스 : 응답 시 반응할 데이터 형식 (현재는 엑스엠엘으로 파일을 뿌려준다)
	public @ResponseBody Building shopSearch(FloorSelector fs) {

		return bDAO.searchShop(fs);
	}
	
}
