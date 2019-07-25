package com.lti.service;

import java.util.List;

import com.lti.bean.Employee;
import com.lti.dao.EmployeeDAO;
import com.lti.dao.EmployeeDAOImpl;


public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao=new EmployeeDAOImpl();

	@Override
	public boolean createNewEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.insertEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	@Override
	public List<Employee> getEmployeeByDept(int dept) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByDept(dept);
	}

	@Override
	public boolean updateEmployeeDept(Employee emp) {
		// TODO Auto-generated method stub
		return dao.updateEmployeeDept(emp);
	}
	
}
