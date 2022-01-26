package com.js.smb;

import java.util.List;

public interface MyMapper {

	// 결과가 여러개
		// List 맵핑
	List<Menu> showAllMenu();

	int regMenu(Menu m);

}
