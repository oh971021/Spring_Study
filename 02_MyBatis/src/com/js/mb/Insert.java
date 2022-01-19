package com.js.mb;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Insert {
	public static void main(String[] args) {

		try {
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
		
			System.out.println("성공");
			
			Scanner k = new Scanner(System.in);
			System.out.println("==커피 등록==");
			System.out.print("커피명 : ");
			String name = k.next();
			
			System.out.print("가격 : ");
			int price = k.nextInt();
						
			// 데이터를 mapper.xml으로 넘겨줘야 함.
				// 객체를 만들어서 보내준다 (ORM Frame Work)
			Coffee c = new Coffee(name, price);
			
			// rs.executeUpdate() 와 같은 역할을 한다.
				// 값을 넘겨줄 때는 객체형태로 만들어서 넘겨준다.
			if (ss.insert("jsqqq.regCoffee", c) == 1) {
				System.out.println("커피 등록 성공");
				
				// 값이 추가 된 것을 확인하고, commit을 해줘야 한다.
				ss.commit();
			} else {
				System.out.println("등록 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
