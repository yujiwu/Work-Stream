package com.workstream.pojo;

import java.io.Serializable;

/**
 * correspond to the attendance it includes attendance time, employee,
 * attendType and has-shift
 */
public class Attend implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer attendId;
	private String dutyDate;
	private String dutyTime;
	private boolean isCome;
	private AttendType attendType;
	private Employee employee;

	public Integer getAttendId() {
		return attendId;
	}

	public void setAttendId(Integer attendId) {
		this.attendId = attendId;
	}

	public String getDutyDate() {
		return dutyDate;
	}

	public void setDutyDate(String dutyDate) {
		this.dutyDate = dutyDate;
	}

	public String getDutyTime() {
		return dutyTime;
	}
	
	public void setDutyTime(String dutyTime) {
		this.dutyTime = dutyTime;
	}

	public boolean isCome() {
		return isCome;
	}

	public void setCome(boolean isCome) {
		this.isCome = isCome;
	}

	public AttendType getAttendType() {
		return attendType;
	}

	public void setAttendType(AttendType attendType) {
		this.attendType = attendType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
