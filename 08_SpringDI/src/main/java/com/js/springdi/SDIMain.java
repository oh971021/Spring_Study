package com.js.springdi;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SDIMain {
	public static void main(String[] args) {
		
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		// 강아지
			// 이름
			// 나이
			// 정보출력
		
		// xml에 작성한 bean id를 앞에 적고, 뒤에는 무슨 클래스인지 적어준다 클래스명.class
			// beans.xml에 만들어놓은 id가  d인 객체를 불러오는 것
				// beans.xml의 객체는 최초로 부를 때 생성된다.
			// 클래스가 Dog라서 변수의 클래스도 맞춰준 것
		Dog d = dlbf.getBean("d", Dog.class); 
		System.out.println(d);		
		
		Dog d2 = dlbf.getBean("d", Dog.class);
		System.out.println(d);
		
		d2.info();
		
		System.out.println("===========================");
		
		// 새로운 객체를 만드려면 xml에 하나 더 만들어 줘야 한다.
		Dog d3 = dlbf.getBean("d2", Dog.class);
		System.out.println(d3);
		
		d3.info();
		
		System.out.println("===========================");
		
		// 이름이 초코, 나이가 1살 강아지 만들고 정보 출력
		Dog d4 = dlbf.getBean("d3", Dog.class);
		System.out.println(d4);
		
		d4.info();
		
		System.out.println("===========================");
		
		Dog d5 = dlbf.getBean("d4", Dog.class);
		System.out.println(d5);
		
		d5.info();
		
		System.out.println("===========================");
		// ############################################ //
		
		// 이름이 준석, 나이가 26, 키가 190, 체중이 85인 사람을 생성 후 그 사람 정보 출력 (생성자로)
		Human js = dlbf.getBean("js", Human.class);
		js.info();
		
		System.out.println("===========================");
		
		// 이름이 동찬, 나이가 26, 키가 180, 체중이 75인 사람을 생성 후 그 사람 정보 출력 (생성자로)		
		Human dc = dlbf.getBean("dc", Human.class);
		dc.info();
		
		System.out.println("===========================");
		// ############################################ //
		
		// 커피
			// 아메리카노
				// 재료 - 원두, 물
				// 영양정보 - 탄, 단, 지
		
		Coffee c = dlbf.getBean("c", Coffee.class);
		c.printInfo();
		
		System.out.println("===========================");
		// ############################################ //
		
		// 고양이
		
		Cat cat = dlbf.getBean("cat", Cat.class);
		cat.info();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
