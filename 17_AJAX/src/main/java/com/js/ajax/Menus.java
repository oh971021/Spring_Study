package com.js.ajax;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
public class Menus {

	private List<Menu> menus;
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public Menus(List<Menu> menus) {
		super();
		this.menus = menus;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	@XmlElement
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	
	
}
