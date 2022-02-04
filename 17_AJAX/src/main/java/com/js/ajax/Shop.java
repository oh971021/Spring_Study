package com.js.ajax;

public class Shop {
	private int b_floor;
	private String b_shopName;
	
	public Shop() {}

	public Shop(int b_floor, String b_shopName) {
		super();
		this.b_floor = b_floor;
		this.b_shopName = b_shopName;
	}

	public int getB_floor() {
		return b_floor;
	}

	public void setB_floor(int b_floor) {
		this.b_floor = b_floor;
	}

	public String getB_shopName() {
		return b_shopName;
	}

	public void setB_shopName(String b_shopName) {
		this.b_shopName = b_shopName;
	}
		
}
