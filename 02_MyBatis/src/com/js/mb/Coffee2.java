package com.js.mb;

public class Coffee2 {
	private int price1; // 인상 전
	private int price2; // 인상 후
	
	public Coffee2() {
		// TODO Auto-generated constructor stub
	}

	public Coffee2(String c_name, int c_price, int price2) {
		super();
		this.price1 = c_price;
		this.price2 = price2;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}
	
	
}
