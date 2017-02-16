package com.workstream.dao;

import java.util.List;

import com.workstream.pojo.Employee;
import com.workstream.pojo.Payment;

public class PaymentDao extends BaseDaoImpl<Payment>{
	public List<Payment> findPaymentByEmployee(Employee employee){
		String hql = "From Payment p where p.employee = ?";
		return find(hql , employee);
	}
}
