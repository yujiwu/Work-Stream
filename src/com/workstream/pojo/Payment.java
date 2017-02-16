package com.workstream.pojo;

import java.io.Serializable;

/**
 * month, employee, amount of salary
 */
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer paymentId; 
	private String month;
	private Employee employee;
	private double salary;
	
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
