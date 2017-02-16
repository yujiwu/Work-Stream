package com.workstream.pojo;

import java.io.Serializable;

/**
 * correspond to the applications about change of attendance it includes
 * application reason, acceptd/refused, and what kind of types need to be
 * changed
 */
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer applicationId;
	private String reason;
	private boolean isAccept;
	private Attend attend;
	private Integer attendTypeId;
	private CheckBack checkBack;

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public Attend getAttend() {
		return attend;
	}

	public void setAttend(Attend attend) {
		this.attend = attend;
	}

	public Integer getAttendTypeId() {
		return attendTypeId;
	}

	public void setAttendTypeId(Integer attendTypeId) {
		this.attendTypeId = attendTypeId;
	}

	public CheckBack getCheckBack() {
		return checkBack;
	}

	public void setCheckBack(CheckBack checkBack) {
		this.checkBack = checkBack;
	}
}
