package com.seed.service;

import java.util.List;

import com.seed.dao.AddressDao;
import com.seed.dao.EmployeeDao;
import com.seed.dao.EmployeeDaoImpl;
import com.seed.dao.AddressDaoImpl;
import com.seed.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao empDao = new EmployeeDaoImpl();
	private AddressDao addressDao = new AddressDaoImpl();

	@Override
	public Employee addEmployee(Employee employee) {
		addressDao.save(employee.getAddress());
		return empDao.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.update(employee);
	}

	@Override
	public Employee deleteEmployee(Long employeeId) {
		return empDao.delete(employeeId);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return empDao.findById(employeeId);
	}

	@Override
	public List<Employee> getEmployees() {
		return empDao.findAll();
	}

}
