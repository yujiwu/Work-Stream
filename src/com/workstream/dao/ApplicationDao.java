package com.workstream.dao;

import java.util.List;

import com.workstream.pojo.Application;
import com.workstream.pojo.Employee;


public class ApplicationDao extends BaseDaoImpl<Application> {
	/**
	 * @param employee
	 * @return employee's applications 
	 */
	public List<Application> findByEmp(Employee employee){
		String hql = "From Application a where a.attend.employee = ?";
		return find(hql , employee);
	}
}
