package com.seed.service;

import java.util.List;


import com.seed.dao.EmployeeDao;
import com.seed.dao.EmployeeDaoImpl;
import com.seed.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	public Employee addEmployee(Employee employee) {
		//addressDao.save(employee.getAddress()); //need to insert address it cascade type is not mentioned
		return empDao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.update(employee);
	}

	@Override
	public Employee deleteEmployee(Integer employeeId) {
		return empDao.delete(employeeId);
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return empDao.findById(employeeId);
	}

	@Override
	public List<Employee> getEmployees() {
		return empDao.findAll();
	}

}
