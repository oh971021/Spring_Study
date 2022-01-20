package com.js.mb.main;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class M {

	public static void Connect(HttpServletRequest request) {

		try {
			
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession ss = sqlSessionFactory.openSession();
		
			System.out.println("성공");
			request.setAttribute("result", "성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "실패");
		}
		
		
		
		
	}

	
}
