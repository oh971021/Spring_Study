package com.js.mb;

import java.sql.Date;

public class Product {
	private int p_no;
	private String p_name;
	private int p_price;
	private String p_img;
	private Date p_exp;
	
	public Product() {}

	public Product(int p_no, String p_name, int p_price, String p_img, Date p_exp) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_img = p_img;
		this.p_exp = p_exp;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public Date getP_exp() {
		return p_exp;
	}

	public void setP_exp(Date p_exp) {
		this.p_exp = p_exp;
	}
}

