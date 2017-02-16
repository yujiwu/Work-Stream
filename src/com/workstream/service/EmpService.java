package com.workstream.service;

import java.util.List;

import com.workstream.pojo.Attend;
import com.workstream.pojo.AttendType;
import com.workstream.pojo.Manager;
import com.workstream.pojo.Payment;

public interface EmpService {

		public int validateLogin(Manager manager);
		public void autoPunch();
		public void autoPay();
		public int Punch(String name, String dutyDay);
		public List<Payment> empSalary(String name);
		public List<Attend> unAttend(String name);
		public List<AttendType> getAllType();
		public boolean addApplication(int attendId, int attendTypeId, String reason);
}
