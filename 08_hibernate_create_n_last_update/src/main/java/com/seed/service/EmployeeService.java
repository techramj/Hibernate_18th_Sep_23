package com.seed.service;

import java.util.List;

import com.seed.dao.EmployeeDao;
import com.seed.entitty.Employee;

public class EmployeeService {
	
	private EmployeeDao empDao = new EmployeeDao();
	
	public Employee addEmployee(Employee emp) {
		return empDao.addEmployee(emp);
	}
	
	public Employee deleteEmployee(int id) {
		return empDao.deleteEmployee(id);
	}
	
	public Employee updateEmployee(Employee emp) {
		return empDao.updateEmployee(emp);
	}
	
	public List<Employee> getEmployees(){
		return empDao.getEmployees();
	}
	
	public Employee getEmployeeById(int id) {
		return empDao.getEmployee(id);
	}

}
