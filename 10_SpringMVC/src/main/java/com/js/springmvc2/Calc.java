package com.js.springmvc2;

import org.springframework.ui.Model;

public class Calc {

	public static void mul(Data2 d, Model model) {

		int result = d.getPrice() * d.getCount();
		
		model.addAttribute("result", result);
		
		
	}


}
