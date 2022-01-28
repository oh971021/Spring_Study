package com.js.smb;

import java.util.List;

public interface MyMapper {

	// 결과가 여러개
		// List 맵핑

	// CUD = int
		// U = 결과가 여러개가 예상 되면 >= 1로 작업
	
	// 디테일을 보고싶다. (결과 하나)
		// 객체로 결과를 받음
			// ${JavaBean}을 Spring에서 자동 매핑 해주는 경우가 있음.
				// 이럴 때는 어트리뷰트 이름을 다른 이름으로 지정해서 사용 함.
	
	List<Menu> showAllMenu();
	
	int regMenu(Menu m);

	int delMenu(Menu m);

	int updateMenu(Menu m);
	
//	int updateMenu2(Menu m);

	Menu getMenu(Menu m);

	
}
