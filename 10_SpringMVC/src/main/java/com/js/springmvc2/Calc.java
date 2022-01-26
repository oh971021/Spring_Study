package com.js.springmvc2;

import org.springframework.ui.Model;

public class Calc {

	public static void mul(Data2 d, Model model) {

		int result = d.getPrice() * d.getCount();
		
		model.addAttribute("result", result);
		
		
	}

	public static void add(Data3 d, Model m) {

		int result = 0;
		
		if (d.getSign().equals("1")) {			
			result = d.getX() + d.getY();
		} else {
			result = d.getX() - d.getY();
		}
		
		m.addAttribute("result", result);
		
	}


}
