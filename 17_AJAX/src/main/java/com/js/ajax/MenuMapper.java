package com.js.ajax;

import java.util.List;

public interface MenuMapper {

	List<Menu> getAllMenu();

	List<Menu> getMenuByName(Menu m);

}
