package com.workstream.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.workstream.dao.ApplicationDao;
import com.workstream.dao.AttendDao;
import com.workstream.dao.AttendTypeDao;
import com.workstream.dao.EmployeeDao;
import com.workstream.dao.ManagerDao;
import com.workstream.dao.PaymentDao;
import com.workstream.pojo.Application;
import com.workstream.pojo.Attend;
import com.workstream.pojo.AttendType;
import com.workstream.pojo.Employee;
import com.workstream.pojo.Manager;
import com.workstream.pojo.Payment;

public class EmpServiceImpl implements EmpService {

	private ApplicationDao applicationDao;
	private AttendDao attendDao;
	private AttendTypeDao attendTypeDao;
	private EmployeeDao employeeDao;
	private ManagerDao managerDao;
	private PaymentDao paymentDao;

	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

	public void setAttendDao(AttendDao attendDao) {
		this.attendDao = attendDao;
	}

	public void setAttendTypeDao(AttendTypeDao attendTypeDao) {
		this.attendTypeDao = attendTypeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	/**
	 * @param manager
	 *            warp the name and password returned integer: 0 means fail, 1
	 *            means employee, 2 means manager
	 */
	@Override
	public int validateLogin(Manager manager) {
		// if it is a manager
		if (managerDao.findByNameAndPass(manager).size() > 0)
			return 2;
		// or it is just an employee
		else if (employeeDao.findByNameAndPass(manager).size() > 0)
			return 1;
		else
			return 0;
	}

	/**
	 * After 7 o'clock, the system will add an Not-Come record for each employee
	 * in weekdays automatically;
	 */
	private static final int Normal = 1;
	// private static final int Personal = 2;
	// private static final int Sick = 3;
	private static final int Late = 4;
	private static final int LeaveEarly = 5;
	private static final int Missing = 6;

	@Override
	public void autoPunch() {
		System.out.println("add Not-Come record for each employee");
		List<Employee> emps = employeeDao.getAll(Employee.class);
		for (Employee emp : emps) {
			AttendType attendType = attendTypeDao.get(AttendType.class, Missing);
			Attend attend = new Attend();
			attend.setAttendType(attendType);
			// the format of the date is like 2016-07-04
			attend.setDutyDate(new java.sql.Date(System.currentTimeMillis()).toString());
			attend.setEmployee(emp);
			attend.setCome(false);
			attendDao.save(attend);
		}
	}

	/**
	 * monthly pay at the 3rd day of next month eg. the salary of June is payed
	 * by July 3rd
	 */
	@Override
	public void autoPay() {
		System.out.println("Auto Pay");
		// get all employees
		List<Employee> emps = employeeDao.getAll(Employee.class);
		// get the number of the previous month
		Calendar currentMonth = Calendar.getInstance();
		currentMonth.add(Calendar.DAY_OF_MONTH, -7);
		String previousMonth = new SimpleDateFormat("yyyy-MM").format(currentMonth.getTime());

		for (Employee emp : emps) {
			Payment payment = new Payment();
			payment.setEmployee(emp);
			payment.setMonth(previousMonth);
			// get the max salary
			double Salary = emp.getSalary();
			List<Attend> attends = attendDao.findByEmpAndMonth(emp, previousMonth);
			// check the attendance records
			for (Attend attend : attends) {
				Salary = Salary - attend.getAttendType().getAmerce();
			}
			payment.setSalary(Salary);
			paymentDao.save(payment);
		}
	}

	/**
	 * 0 means cannot punch 1 means come-punch is successful 2 means leave-punch
	 * is successful
	 */
	@Override
	public int Punch(String name, String dutyDay) {
		// get the name corresponded employee object
		Employee emp = employeeDao.findByName(name);
		// get that employee's attendance record
		List<Attend> attends = attendDao.findByEmpAndDutyDay(emp, dutyDay);
		if (attends == null || attends.size() < 1) {
			return 0;
		} // if the employee has an attendance record and is not come
		else if (attends.size() == 1 && !attends.get(0).isCome() && attends.get(0).getDutyTime() == null) {
			// update this attendance record
			Attend attend = attends.get(0);
			attend.setCome(true);
			int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			if (currentHour < 9) {
				attend.setDutyTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
				attend.setAttendType(attendTypeDao.get(AttendType.class, Normal));
				attend.setCome(true);
			} else if (currentHour >= 9 && currentHour < 11) {
				attend.setDutyTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
				attend.setAttendType(attendTypeDao.get(AttendType.class, Late));
				attend.setCome(true);
			} else {
				return 0;
			}
			attendDao.update(attend);
			return 1;
		} else if (attends.size() == 1 && attends.get(0).isCome()) {
			// save this attendance record
			int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			Attend attend = new Attend();
			if (currentHour < 18) {
				attend.setCome(true);
				attend.setAttendType(attendTypeDao.get(AttendType.class, LeaveEarly));
				attend.setDutyDate(dutyDay);
				attend.setDutyTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
				attend.setEmployee(emp);
			} else {
				attend.setCome(true);
				attend.setAttendType(attendTypeDao.get(AttendType.class, Normal));
				attend.setDutyDate(dutyDay);
				attend.setDutyTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
				attend.setEmployee(emp);
			}
			attendDao.save(attend);
			return 2;
		} else {
			return 0;
		}
	}

	@Override
	public List<Payment> empSalary(String name) {
		Employee emp = employeeDao.findByName(name);
		return paymentDao.findPaymentByEmployee(emp);
	}

	@Override
	public List<Attend> unAttend(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttendType> getAllType() {
		return attendTypeDao.getAll(AttendType.class);
	}

	@Override
	public boolean addApplication(int attendId, int attendTypeId, String reason) {
		// create an application
		Application application = new Application();
		//get the corresponding attendance record
		Attend attend = attendDao.get(Attend.class, attendId);
		try {
			application.setAttend(attend);
			application.setReason(reason);
			application.setAttendTypeId(attendTypeId);
			applicationDao.save(application);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
