package com.seed;

import com.seed.entity.Address;
import com.seed.entity.Employee;
import com.seed.service.AddressService;
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
		EmployeeServiceImpl empService = new EmployeeServiceImpl(); //loose coupling
		
		Address add1= new Address("Pune", "411011");
		Employee emp1  = new Employee("Jack", 5000.0, add1);
		add1.setEmployee(emp1);
		
		Address add2= new Address("Mumbai", "211011");
		Employee emp2  = new Employee("Jessica", 15000.0, add2);
		add2.setEmployee(emp2);
		
		
		empService.addEmployee(emp1);
		empService.addEmployee(emp2);
		
	}
	
}
