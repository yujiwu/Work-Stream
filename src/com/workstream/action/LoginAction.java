package com.workstream.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.workstream.pojo.Manager;

public class LoginAction extends BaseAction implements ModelDriven<Manager>{
	
	private static final long serialVersionUID = 1L;
	
	//the model used for store the field name and password from jsp file
	private Manager manager;

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public Manager getModel() {
		manager = new Manager();
		return manager;
	}
	
	
	@Override
	public String execute() throws Exception {
		/**
		ApplicationContext ctx = WebApplicationContextUtils.
				getWebApplicationContext(ServletActionContext.getServletContext());
		 */
		
		//get action context (request, session, ServletContext application...)
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		
		//result equals 0 means fail, 1 means employee, 2 means manager
		int result = empService.validateLogin(manager);
		if(result == 2){
			session.put("name", manager.getName());
			return "manager";
		}else if(result == 1){
			session.put("name", manager.getName());
			return "employee";
		}else{
			addActionError("Name or password is incorrect");
			return INPUT;
		}
	}

	/**
	 * if validating by programming the 
	 * action need to implement the Validateable interface. 
	 * ActionSupport has already implement that interface 
	 * but the validate() is empty, we can implement this method 
	 * by override it
	
	@Override
	public void validate() {
		addActionMessage("");
	}
	 */
}