package com.workstream.pojo;

/**
 * correspond to the application, whether the application passes, who check the
 * application
 */
public class CheckBack {

	private Integer checkBackId;
	private Application application;
	private boolean isAccept;
	private Manager manager;

	public Integer getCheckBackId() {
		return checkBackId;
	}

	public void setCheckBackId(Integer checkBackId) {
		this.checkBackId = checkBackId;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
