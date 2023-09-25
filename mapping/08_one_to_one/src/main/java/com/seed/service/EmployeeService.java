package com.seed.service;

import java.util.List;

import com.seed.entity.Employee;

public interface EmployeeService {
	 Employee addEmployee(Employee employee);
	 Employee updateEmployee(Employee employee);
	 Employee deleteEmployee(Long employeeId);
	 Employee getEmployeeById(Long employeeId);
	 List<Employee> getEmployees();

}
