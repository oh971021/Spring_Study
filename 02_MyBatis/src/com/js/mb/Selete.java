package com.js.mb;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// My Batis : java bean과 자동으로 mapping 해주는 역할
	// 유지보수를 보다 수월하게 하기 위해 수정사항이 잦은 파일은 외부파일로 뽑아내서 관리하는 것.

public class Selete {
	public static void main(String[] args) {

		try {
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
		
			System.out.println("성공");
		
			// My Batis로 select 하면
				// JSP에서 : execute 실행해서 ResultSet에 담아서 Bean, 객체, arraylist에 값 add
				// 이 작업들을 Batis는 프레임워크를 설치함으로써 자동으로 해줌
			
					// 하지만 프레임워크는 정해진 규칙에 따라 설계를 해야한다.
				// 1. Bean의 멤버변수명이 DB필드명과 같아야 한다.
				// 2. mapper.xml
					// - 자바 객체로 만들어서 주기때문에 출력 타입을 정해 줘야함 : resultType 셋팅
					// - namespace를 통해서 mapper를 찾아간다.
					// - namespace.TagId를 통해서 select의 sql문을 찾아간다.
			
			// 매퍼의 namespace명.매퍼의 id명
			List<Coffee> coffees = ss.selectList("jsqqq.getAllCoffee");
			
			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
