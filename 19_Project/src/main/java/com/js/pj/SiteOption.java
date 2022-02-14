package com.js.pj;

import javax.servlet.http.HttpServletRequest;

public class SiteOption {

	private int snsCountPerpage; // 한 페이지 당 보여질 게시글 수
	
	public SiteOption() {
		// TODO Auto-generated constructor stub
	}

	public SiteOption(int snsCountPerpage) {
		super();
		this.snsCountPerpage = snsCountPerpage;
	}

	public int getSnsCountPerpage() {
		return snsCountPerpage;
	}

	public void setSnsCountPerpage(int snsCountPerpage) {
		this.snsCountPerpage = snsCountPerpage;
	}

	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
}
