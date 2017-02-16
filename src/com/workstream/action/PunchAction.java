package com.workstream.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class PunchAction extends BaseAction {

	//discriminate manager or employee
	private String level;
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		String name = (String) session.get("name");
		String dutyDay = (new SimpleDateFormat("MM-dd-yyyy")).format(new Date());
		int result = empService.Punch(name, dutyDay);
		
		switch (result){
			case 0: addActionError("cannot punch");
						return level;
			case 1: addActionMessage("come punch success");
						return level;
			case 2: addActionMessage("leave punch success");
						return level;
			//won't reach here
			default: return "end";
		}
	}
	
}
