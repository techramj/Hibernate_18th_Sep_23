package com.seed;

import com.seed.entity.Employee;
import com.seed.entity.Manager;
import com.seed.entity.SalesPerson;
import com.seed.service.EmployeeServiceImpl;

import oracle.net.jdbc.TNSAddress.Address;

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
		
		
		Employee emp1 = new Employee("Jack", 5000.0);
		Employee emp2 = new SalesPerson("Sam", 8000.0,20000,1);
		Employee emp3 = new Manager("Jessica",10000.0,1000);
		
		Employee emp4 = new Employee("Jackie", 15000.0);
		Employee emp5 = new SalesPerson("Sameer", 18000.0,20000,1);
		Employee emp6 = new Manager("Jassi",11000.0,2000);
		
		
		
		empService.addEmployee(emp1);
		empService.addEmployee(emp2);
		empService.addEmployee(emp3);
		empService.addEmployee(emp4);
		empService.addEmployee(emp5);
		empService.addEmployee(emp6);
			
	}
	
}
