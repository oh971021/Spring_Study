package com.js.pj.sns;

import java.math.BigDecimal;

public class SNSSelector {

	// 이 친구들은 검색을 위한 변수들을 저장한다.
	
	private String search;	// 검색어 처리
	private BigDecimal start;	// 숫자가 필요할 때 사용하려고 선언
	private BigDecimal end;
	
	public SNSSelector() {
		// TODO Auto-generated constructor stub
	}

	public SNSSelector(String search, BigDecimal start, BigDecimal end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
}
