package com.workstream.dao;

import java.util.List;

import com.workstream.pojo.Employee;

public class EmployeeDao extends BaseDaoImpl<Employee>{
	public List<Employee> findByNameAndPass(Employee employee){
		String hql = "From Employee e where e.name=? and e.password = ?";
		return find(hql , employee.getName(), employee.getPassword());
	}
	
	public Employee findByName(String name){
		String hql = "From Employee e where e.name=? ";
		List<Employee> emps = find(hql , name);
		if(emps != null && emps.size() > 1){
			return emps.get(0);
		}
		return null;
	}
}
