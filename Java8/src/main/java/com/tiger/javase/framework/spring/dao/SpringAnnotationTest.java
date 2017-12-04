package com.tiger.javase.framework.spring.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationTest {
	public void testSpringAnnotation() {
		System.out.println("Before");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao ud = (UserDao) ac.getBean("userDao");
		ud.sayHello();
		System.out.println("After");
	}

	public static void main(String[] args) {
		System.out.println("Before main.");
	}
}
