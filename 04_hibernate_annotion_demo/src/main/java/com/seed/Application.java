package com.seed;

import com.seed.entitty.Employee;
import com.seed.service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		fetchDemo();
	}
	
	public static void fetchDemo() {
		EmployeeService empService = new EmployeeService();
		Employee e1 = empService.getEmployeeById(111);
		Employee e2 = empService.getEmployeeById(100);
		
		System.out.println(e1);
		System.out.println(e2);
	}

	public static void insertDemo() {
		EmployeeService empService = new EmployeeService();

		Employee e1 = new Employee(111, "Sam", 10000.0);
		Employee e2 = new Employee(112, "Sameer", 20000.0);

		empService.addEmployee(e1);
		empService.addEmployee(e2);
	}

}
