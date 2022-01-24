package com.js.springdi;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

// Spring ? : IoC로 DI 해주는 framework
			// 유지보수를 위해 사용

// DI (Dependency Injection) - 의존성 주입 
	// 객체 만들고, 속성 값 세팅하는 것 (필요한 값들을 주입시켜 줌)
		// 객체에 필요한 값들을 정의해주는 것
	// 애플폰 만들고, 모델명/무게/가격 등 셋팅

// IoC (Inversion of Control) - 제어의 역전
	// P(program) -> F(file) 제어가 일반적이지만
	// F(file) -> P(program) 으로 역전됨

public class SIMain {
	public static void main(String[] args) {
		
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("asd.xml"));
		
		// 2. 다형성
		Phone p = dlbf.getBean("phone", Phone.class);
		p.logo();
		
	}
}
