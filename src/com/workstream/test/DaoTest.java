package com.workstream.test;


import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

	@Test
	public void test() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(new Date().toString());
		System.out.println(new Date(System.currentTimeMillis()).toString());
		System.out.println(new java.sql.Date(System.currentTimeMillis()));
	}

}
