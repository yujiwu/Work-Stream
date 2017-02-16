package com.workstream.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * employee name, password, salary, and manager
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer employeeId; 
	
	private String name;
	
	private String password;
	
	private double salary;
	
	private Manager manager;
	
	private Set<Attend> attends = new HashSet<>();
	
	private Set<Payment> payments = new HashSet<>();

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Attend> getAttends() {
		return attends;
	}

	public void setAttends(Set<Attend> attends) {
		this.attends = attends;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
