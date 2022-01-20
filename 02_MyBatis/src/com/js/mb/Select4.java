package com.js.mb;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Select4 {
	public static void main(String[] args) {
		
		try {
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
		
			System.out.println("성공");
			
			// 가격 (~이상 ~이하) 검색
				// ex) 1000이상 5000이하의 커피 검색
			
			Scanner k = new Scanner(System.in);
			
			System.out.print("가격 1 (~이상) : ");
			int price1 = k.nextInt();
			
			System.out.print("가격 2 (~이하) : ");
			int price2 = k.nextInt();
			
			Price price = new Price();
			
			price.setPrice1(price1);
			price.setPrice2(price2);
			
			List<Coffee> coffees = ss.selectList("jsqqq.getCoffeePriceToPrice", price);

			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("=========");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
