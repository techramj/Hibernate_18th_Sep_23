package com.seed.dao;

import java.util.List;

import com.seed.entity.Employee;

public interface EmployeeDao {
	
	 Employee save(Employee employee);
	 Employee update(Employee employee);
	 Employee delete(Integer employeeId);
	 Employee findById(Integer employeeId);
	 List<Employee> findAll();
	 List<Employee> findAllSalesPerson();
	 List<Employee> findAllManager();
	 List<Employee> findAllCeo();
}
