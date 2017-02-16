package com.workstream.action;


import com.opensymphony.xwork2.ActionSupport;
import com.workstream.service.EmpService;

public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	protected EmpService empService;
	
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
}
