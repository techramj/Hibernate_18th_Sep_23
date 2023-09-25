package com.seed;

import com.seed.entitty.Employee;
import com.seed.service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		//fetchDemo();
		//insertDemo();
		//deleteExample();
		//updateExample();
		
		displayAllEmployee();
	}
	
	public static void displayAllEmployee() {
		EmployeeService empService = new EmployeeService();
		empService.getEmployees().forEach(e-> display(e));
	}
	
	public static void updateExample() {
		Employee emp = new Employee("Sam",20000.0);
		emp.setId(1);
		EmployeeService empService = new EmployeeService();
		Employee updatedEmp = empService.updateEmployee(emp);
		System.out.println(updatedEmp.getName()+"  "+updatedEmp.getSalary());
	}
	
	public static void deleteExample() {
		int id= 1001;
		EmployeeService empService = new EmployeeService();
		Employee emp = empService.deleteEmployee(id);
		System.out.println(emp.getName()+"  "+emp.getSalary());
	}
	
	public static void fetchDemo() {
		EmployeeService empService = new EmployeeService();
		Employee e1 = empService.getEmployeeById(1001);
		display(e1);
	}

	public static void insertDemo() {
		EmployeeService empService = new EmployeeService();

		Employee e1 = new Employee("Sam", 10000.0);
		Employee e2 = new Employee("Sameer", 20000.0);

		empService.addEmployee(e1);
		empService.addEmployee(e2);
	}
	
	private static void display(Employee e) {
		System.out.println("Name: "+e.getName());
		System.out.println("Salary: "+e.getSalary());
		System.out.println();
		System.out.println("---------------------------------------------");
	}

}
