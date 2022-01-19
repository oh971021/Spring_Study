package com.js.mb;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Select2 {
	public static void main(String[] args) {
		
		// 이름으로 검색
		
		try {
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
		
			System.out.println("성공");
		
			Scanner k = new Scanner(System.in);
			
			System.out.print("커피 이름 : ");
			String name = k.next();
			
			Coffee c = new Coffee();
			c.setC_name(name);
			
			List<Coffee> coffees = ss.selectList("jsqqq.getCoffee", c);
			
			for (Coffee cf : coffees) {
				System.out.println(cf.getC_name());
				System.out.println(cf.getC_price());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
