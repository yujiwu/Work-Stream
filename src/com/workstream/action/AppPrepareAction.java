package com.workstream.action;

import java.util.List;

import com.workstream.pojo.AttendType;

public class AppPrepareAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private List<AttendType> attendTypes;

	public void setAttendTypes(List<AttendType> attendTypes) {
		this.attendTypes = attendTypes;
	}

	public List<AttendType> getAttendTypes() {
		return attendTypes;
	}

	@Override
	public String execute() throws Exception {
		// get all attandance types
		setAttendTypes(empService.getAllType());
		return SUCCESS;
	}
}
