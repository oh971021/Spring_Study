package com.js.ajax;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

// xml을 body에 뿌려줄 때, 요소 정의를 해줘야함
@XmlRootElement
public class Building {

	// 빌딩안에 가게들이 있다.
	private List<Shop> shops;
	
	public Building() {
		// TODO Auto-generated constructor stub
	}

	public Building(List<Shop> shops) {
		super();
		this.shops = shops;
	}

	public List<Shop> getShops() {
		return shops;
	}

	@XmlElement
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	
}
