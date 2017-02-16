package com.workstream.pojo;

/**
 * attendance name: late or leave early
 */
public class AttendType {

	private Integer attendTypeId;
	private String name;
	private double amerce;

	public Integer getAttendTypeId() {
		return attendTypeId;
	}

	public void setAttendTypeId(Integer attendTypeId) {
		this.attendTypeId = attendTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmerce() {
		return amerce;
	}
	
	public void setAmerce(double amerce) {
		this.amerce = amerce;
	}
}
