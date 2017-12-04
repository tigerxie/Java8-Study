package com.tiger.javase.framework.spring.dao;

import org.springframework.stereotype.Component;

@Component(value= "userDao")
public class UserDaoImpl implements UserDao {
	@Override
	public void sayHello() {
		System.out.println("Hello Spring...");
	}
}
