package com.seed.dao;

import java.util.List;

import com.seed.entity.Employee;

public interface EmployeeDao {
	
	 Employee save(Employee employee);
	 Employee update(Employee employee);
	 Employee delete(Long employeeId);
	 Employee findById(Long employeeId);
	 List<Employee> findAll();
}
