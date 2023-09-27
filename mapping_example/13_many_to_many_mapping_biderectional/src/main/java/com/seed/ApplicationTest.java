package com.seed;

import com.seed.entity.Project;
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
		EmployeeService empService = new EmployeeServiceImpl(); 
		
		
		Employee emp1  = new Employee("Jack", 5000.0);
		Employee emp2  = new Employee("Jessica", 15000.0);
		Employee emp3  = new Employee("Sam", 10000.0);
		
		Project p1  = new Project("EMS");
		Project p2  = new Project("TMS");
		Project p3  = new Project("BMS");
		
		emp1.addProjects(p1,p2);
		emp2.addProjects(p2,p3);
		emp3.addProjects(p1,p2,p3);
		
		p1.addEmployees(emp1, emp3);
		p2.addEmployees(emp1, emp2, emp3);
		p3.addEmployees(emp2, emp3);
		
		empService.addEmployee(emp1);
		empService.addEmployee(emp2);
		empService.addEmployee(emp3);
	}
	
}
