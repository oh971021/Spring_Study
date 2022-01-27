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
			System.out.println("등록 실패!");
			req.setAttribute("r", "등록 실패!");
		};
		
	}
	
	public void delMenu(Menu m, HttpServletRequest req) {
		
		// 메뉴 삭제
		MyMapper mm = ss.getMapper(MyMapper.class);
		
		// 추상메소드
		if(mm.delMenu(m) >= 1) {
			System.out.println("삭제 성공!");
			req.setAttribute("r", "삭제 성공!");
		} else {
			System.out.println("삭제 실패!");
			req.setAttribute("r", "삭제 실패!");
		};

	}

	public void updateMenu(Menu m, HttpServletRequest req) {

		// 가격 수정
		MyMapper mm = ss.getMapper(MyMapper.class);

		System.out.println(m.getM_name());
		System.out.println(m.getM_price());
/*		
		int result = 0;
		
		if (m.getM_name() != null && m.getM_name() != "") {
			result = mm.updateMenu(m);
		} else {
			result = mm.updateMenu(m);
		}
*/
		if(mm.updateMenu(m) >= 1) {
			System.out.println("수정 성공!");
			req.setAttribute("r", "수정 성공!");
		} else {
			System.out.println("수정 성공!");
			req.setAttribute("r", "수정 성공!");
		};
	}

	public void getMenu(Menu m, HttpServletRequest req) {

		MyMapper mm = ss.getMapper(MyMapper.class);
		
		Menu menus = mm.getMenu(m);
		req.setAttribute("m", menus);
		
		// 스프링이 자바 Bean 이름과 같은 상탤 어트리뷰트 값을 만들어 줌. 
			// 파라미터 값을 셋팅 해주는 상태이기 때문에 파라미터로 받은 게 없으면 셋팅 되지 않는다.
		
			// 결론은 우선순위가 Menu > menu 이름의 어트리뷰트가 우선 (Spring이 자동 세팅해준 어트리뷰트 값)
			// 덮어쓰기 안됨 
				// ex) DAO에서 값을 빼 온 객체를 설정 했다 하더라도 그 값이 덮어씌워 지지 않는다. 
	}

//	public void updateMenu2(Menu m, HttpServletRequest req) {
//		
//		// 메뉴 명 + 가격 수정
//		MyMapper mm = ss.getMapper(MyMapper.class);
//		if(mm.updateMenu2(m) >= 1) {
//			System.out.println("수정 성공!");
//			req.setAttribute("r", "수정 성공!");
//		} else {
//			System.out.println("수정 성공!");
//			req.setAttribute("r", "수정 성공!");
//		};
//	}
}
