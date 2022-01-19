package com.js.mb;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Update {
	public static void main(String[] args) {

		try {

			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("성공");
			
			// 커피 가격 수정
				// 1. 커피이름 입력
				// 2. 커피가격 수정 입력
			
			Scanner k = new Scanner(System.in);
			
			System.out.print("가격 수정할 커피 : ");
			String name = k.next();
			
			System.out.print("수정할 가격 : ");
			int price = k.nextInt();
			
			Coffee c = new Coffee(name, price);
			
			if (ss.update("jsqqq.updatePrice", c) == 1) {
				// 이클립스 DB에서는 자동으로 commit을 해주지만 MyBatis를 이용한 Java DB Project는 commit을 수동으로 해줘야 함.
				ss.commit();
				
				System.out.println("가격 수정 성공!");
			}			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
