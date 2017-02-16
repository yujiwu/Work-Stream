package com.workstream.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * which dept does manager manage
 */
public class Manager extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dept;
	private Set<Employee> employees = new HashSet<>();
	private Set<CheckBack> checks = new HashSet<>();

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<CheckBack> getChecks() {
		return checks;
	}

	public void setChecks(Set<CheckBack> checks) {
		this.checks = checks;
	}

}
