package com.seed;

import com.seed.entitty.Address;
import com.seed.entitty.Employee;
import com.seed.service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		
		insertDemo();
		
	}
	

	public static void insertDemo() {
		EmployeeService empService = new EmployeeService();

		Employee e1 = new Employee( "Sam", 10000.0);
		Address add1 = new Address("Pune", "411011", "Lane no 1");
		e1.setAddress(add1);
		
		Employee e2 = new Employee( "Sameer", 20000.0);
		Address add2 = new Address("Pune", "411012", "Lane no 2");
		e2.setAddress(add2);

		empService.addEmployee(e1);
		empService.addEmployee(e2);
	}

}
