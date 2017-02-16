package com.workstream.action;

public class AppProcessAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private Integer attendId;
	private Integer attendTypeId;
	private String reason;

	public Integer getAttendId() {
		return attendId;
	}

	public void setAttendId(Integer attendId) {
		this.attendId = attendId;
	}

	public Integer getAttendTypeId() {
		return attendTypeId;
	}

	public void setAttendTypeId(Integer attendTypeId) {
		this.attendTypeId = attendTypeId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String execute() throws Exception {
		empService.addApplication(attendId, attendTypeId, reason);
		addActionMessage("Success");
		return SUCCESS;
	}

}
