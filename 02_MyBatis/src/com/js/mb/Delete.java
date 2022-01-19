package com.js.mb;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Delete {
	public static void main(String[] args) {

		try {

			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();

			System.out.println("성공");
			
			// 데이터 삭제하기
			
			Scanner k = new Scanner(System.in);

			System.out.print("삭제할 커피 명 : ");
			String name = k.next();
			
			Coffee cf = new Coffee();
			cf.setC_name(name);
			
			if (ss.delete("jsqqq.deleteCoffee", cf) == 1) {
				ss.commit();
				System.out.println("커피 정보 삭제 성공!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
