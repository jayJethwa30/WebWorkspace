package com.lti.service;

import java.util.List;

import com.lti.bean.Employee;

public interface EmployeeService {

	public boolean createNewEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployee(int id);
	public List<Employee> getEmployeeByDept(int dept);
	public boolean updateEmployeeDept(Employee emp);
	
}
