package com.js.springmvc3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service // Bean 등록 (xml에)
public class M {

	public void add(Bean b, HttpServletRequest req) {
		
		int hab = b.getX() + b.getY();
		int cha = b.getX() + b.getY();
		
		req.setAttribute("hab", hab);
		req.setAttribute("cha", cha);

	}

}
