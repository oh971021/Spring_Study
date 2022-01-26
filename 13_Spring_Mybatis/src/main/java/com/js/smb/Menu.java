package com.js.smb;

import java.math.BigDecimal;

public class Menu {

	private BigDecimal m_no;
	private String m_name;
	private BigDecimal m_price;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(BigDecimal m_no, String m_name, BigDecimal m_price) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_price = m_price;
	}

	public BigDecimal getM_no() {
		return m_no;
	}

	public void setM_no(BigDecimal m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public BigDecimal getM_price() {
		return m_price;
	}

	public void setM_price(BigDecimal m_price) {
		this.m_price = m_price;
	}
	
}
