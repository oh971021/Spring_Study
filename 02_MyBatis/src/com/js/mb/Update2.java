package com.js.mb;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Update2 {
	public static void main(String[] args) {

		try {		
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("성공");

			Scanner k = new Scanner(System.in);
	
			// 커피 가격 수정, 입력받은 값 이상의 커피들의 가격을 입력값으로 변경
			System.out.print("수정하고 싶은 커피 가격 : ");
			int price = k.nextInt();
			
			System.out.print("수정할 가격 : ");
			int price2 = k.nextInt();
			
			Map<String, Integer> val = new HashMap<String, Integer>();
			
			val.put("price1", price);
			val.put("price2", price2);
			
			if (ss.update("jsqqq.updateCoffeePrice", val) >= 1) {
				ss.commit();
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
