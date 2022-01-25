package com.js.springdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain2 {

	public static void main(String[] args) {

		// beans.xml에 등록된거 그냥 다 생성(안불러도 생성)
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		
		// aac가 없어질 때 등록 된 객체들 메모리 정리하기
			// 안불러도 만들어지기 때문에 관리를 해줘야 함
		aac.registerShutdownHook();
		
		Human h = aac.getBean("catMaster", Human.class);
		h.info();
		
		// dlbf가 객체를 불러올 때 딱 생성 해주기 때문에 더 좋은 방식이지만
		// Spring의 어떤 기능들에서는 aac방식을 '반드시' 써야만 하는 경우가 꽤 있다.
		
	}

}
