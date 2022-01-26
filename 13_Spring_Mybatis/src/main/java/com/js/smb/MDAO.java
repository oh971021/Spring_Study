package com.js.smb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// 정리 해주는 상태 (자동연결)
public class MDAO {
	
	@Autowired
	private SqlSession ss; // 서블릿-컨텍스트 에서 빈을 땡겨 쓰는거
	
	public void getAllMenu(HttpServletRequest req) {
		
		// 전체 조회 
			// Mapper에서 sql문을 작성하는데 mapper를 부를때는 인터페이스로 작성 된 매퍼를 부른다. 
		MyMapper mm = ss.getMapper(MyMapper.class);
		
		List<Menu> menus = mm.showAllMenu();
		
		req.setAttribute("m", menus);
		
		
		
	}

	public void regMenu(Menu m, HttpServletRequest req) {
		
		// 메뉴 등록
		MyMapper mm = ss.getMapper(MyMapper.class);
		if (mm.regMenu(m) == 1) {
			System.out.println("등록 성공!");
			req.setAttribute("r", "등록 성공!");
		} else {
			req.setAttribute("r", "등록 실패!");
		};
		
	}
	
}
