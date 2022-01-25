package com.js.springdi;

import java.util.ArrayList;
import java.util.HashMap;

public class Coffee {
	
	private ArrayList<String> jaeryo;			// 재료들 원두, 물, ...
	private HashMap<String, Double> info;		// 영양정보 탄, 단, 지
	
	public Coffee() {}

	public Coffee(ArrayList<String> jaeryo, HashMap<String, Double> info) {
		super();
		this.jaeryo = jaeryo;
		this.info = info;
	}

	public ArrayList<String> getJaeryo() {
		return jaeryo;
	}

	public void setJaeryo(ArrayList<String> jaeryo) {
		this.jaeryo = jaeryo;
	}

	public HashMap<String, Double> getInfo() {
		return info;
	}

	public void setInfo(HashMap<String, Double> info) {
		this.info = info;
	}
	
	public void printInfo() {
		for (String s : jaeryo) {			
			System.out.println(s);
		}
		System.out.println("-----");
		
		System.out.println(info.get("탄"));
		System.out.println(info.get("단"));
		System.out.println(info.get("지"));
	}
	
}
