package com.js.ajax;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

// XRE : 시작점 요소를 지정한다.
@XmlRootElement
public class Building {

	private List<Shop> shop;
	
	public Building() {
		// TODO Auto-generated constructor stub
	}

	public Building(List<Shop> shop) {
		super();
		this.shop = shop;
	}

	public List<Shop> getShop() {
		return shop;
	}

	// xml 요소 지정
	@XmlElement
	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
	
}
