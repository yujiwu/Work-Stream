package com.workstream.dao;

import java.util.List;

import com.workstream.pojo.Attend;
import com.workstream.pojo.Employee;

public class AttendDao extends BaseDaoImpl<Attend>{

	public List<Attend> findByEmpAndDutyDay(Employee employee, String dutyDate){
		String hql = "from Attend a where a.employee = ? and a.dutyDate= ?";
		return find(hql, employee, dutyDate);
	}
	
	public List<Attend> findByEmpAndMonth
				(Employee employee,  String month){
		// in hql, for the function substring, the index starts from 1 and 7 means the next 7 characters
		 return find("from Attend a where a.employee = ? "
				+"and substring(a.dutyDate, 1, 7) = ?",  employee, month);
	}
}
