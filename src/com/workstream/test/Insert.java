package com.workstream.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.workstream.pojo.Attend;

public class Insert {

	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test() {
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Attend attend = new Attend();
		attend.setCome(false);
		attend.setDutyDate(new java.sql.Date(System.currentTimeMillis()).toString());
		attend.setCome(false);
		session.save(attend);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}

}
