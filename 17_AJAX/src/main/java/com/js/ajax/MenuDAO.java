package com.js.ajax;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {

	private SqlSession ss;
	
	public Menus getAllMenu() {
		
		List<Menu> menus = ss.getMapper(MenuMapper.class).getAllMenu();
		
		return new Menus(menus);
	}

	public Menus getMenuJSONByName(Menu ms) {
		List<Menu> menus = ss.getMapper(MenuMapper.class).getMenuByName(ms);
		
		Menus m = new Menus(menus);
		
		return m;
	}

}
