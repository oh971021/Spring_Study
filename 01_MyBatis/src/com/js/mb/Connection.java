package com.js.mb;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 유지보수

// 그 외부 파일이 어떤 형식이 있으면 좋을 것 같다.
	// XNL : 각종 설정파일에서 사용
	// JSON : 네트워크 상에서 데이터 주고 받을 때 사용

// DB

// 서버 정보
	// JDBC (Java Data Base Connection) - Connection, Prepared, ResultSet
		// DBManager.java 를 사용함.
		// SQL문은 DAO에서 사용함.
	
	// MyBatis
		// ConnectionPool - JDBC에서 각각 사용했던 것들을 .xml에 기록해서 외부 파일 접근으로 수정할 수 있도록 만든다.
			// DBManager -> .xml 기록

// 형태							DB연결					SQL
	// JDBC					DBManager.java				DAO.java
	// ConnectionPool			.xml					DAO.java
	// MyBatis					.xml					.xml
		//					-> config.xml				-> mapper.xml 로 예제 실행중
		
// Mybatis (3.x)
	// iBatis (2.x) - 이전버전, 옛날이름
	// DB ORM(Object Relation Mapping) Frame Work : 자바랑 객체랑 자동 매핑, 연결
	// mybatis.jar 필요함 -> .xml에 등록

public class Connection {
	public static void main(String[] args) {
		
		try {

			String resource = "config.xml"; // 서버 정보 담기는 파일
			
			// config.xml 에서 데이터를 읽어낼 수 있는 빨대 : InputStream
			InputStream is = Resources.getResourceAsStream(resource);
			
			// SqlSession을 뽑아내기 위한 작업 빌더 -> 빌드/오픈 -> 세션추출
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder(); // 공장 빌더
			SqlSessionFactory ssf = ssfb.build(is); // 공장 (이 공장은 빌더가 설계도를 가지고 만드는 것)
			SqlSession ss = ssf.openSession();
			
			// 성공 로그
			System.out.println("성공");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
}
