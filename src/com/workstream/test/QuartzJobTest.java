package com.workstream.test;


import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//implement the interface of the Job as the target class of Quartz
//or extends the QuartzJobBean which implements the interface of the Job
public class QuartzJobTest implements Job{

	@Test
	public void test() {
	
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}


}
