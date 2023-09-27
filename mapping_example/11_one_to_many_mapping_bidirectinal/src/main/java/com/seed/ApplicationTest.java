package com.seed;

import com.seed.entity.Department;
import com.seed.entity.Employee;
import com.seed.service.EmployeeService;
import com.seed.service.EmployeeServiceImpl;

public class ApplicationTest {
	
	
	
	public static void main(String[] args) {
		
		addExample();
		//fetchExample();
	}
	
	public static void addAddress() {
		//AddressService
	}
	
	public static void fetchExample() {
		EmployeeServiceImpl empService = new EmployeeServiceImpl(); //loose coupling
		Employee emp = empService.getEmployeeById(1006);
		System.out.println(emp);
	}
	
	
	public static void addExample() {
		EmployeeService empService = new EmployeeServiceImpl(); //loose coupling
		
		Department d1= new Department("IT");
		Employee emp1  = new Employee("Jack", 5000.0, d1);
		
		
		Department d2= new Department("HR");
		Employee emp2  = new Employee("Jessica", 15000.0, d2);
		
		Employee emp3  = new Employee("Sam", 10000.0, d2);
		
		d1.addEmployees(emp1);
		d2.addEmployees(emp2, emp3);
		
		empService.addEmployee(emp1);
		empService.addEmployee(emp2);
		empService.addEmployee(emp3);
	}
	
}
