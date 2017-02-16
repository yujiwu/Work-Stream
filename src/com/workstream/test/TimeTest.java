package com.workstream.test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TimeTest {

	@Test
	public void test() {
//		System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
//		String time1 = new java.sql.Date(System.currentTimeMillis()).toString();
//		System.out.println(time1);
//		String time2 = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
//		System.out.println(time2);
//		String time3 = new SimpleDateFormat("HH:mm:ss").format(new Date());
//		System.out.println(time3);
//		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(Calendar.DAY_OF_MONTH);
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		calendar.add(Calendar.DAY_OF_MONTH, -15);
		System.out.println(calendar.getTime());
		String payMonth = new SimpleDateFormat("yyyy-MM").
				format(calendar.getTime());
		System.out.println(payMonth);
		System.out.println(new java.sql.Date(System.currentTimeMillis()).toString());
	}

}
