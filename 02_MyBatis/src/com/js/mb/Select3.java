package com.js.mb;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Select3 {
	public static void main(String[] args) {
		
		// 입력한 가격 이하의 커피 검색
		
		try {
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
		
			System.out.println("성공");
			
			Scanner k = new Scanner(System.in);
			// 입력한 값
			System.out.print("가격대 : ");
			int price = k.nextInt();

			Coffee cf = new Coffee();
			cf.setC_price(price);
			
			List<Coffee> coffees = ss.selectList("jsqqq.getCoffeeWherePrice", cf);
			
			for (Coffee c : coffees) {
				System.out.println(c.getC_name()); 
				System.out.println(c.getC_price());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
