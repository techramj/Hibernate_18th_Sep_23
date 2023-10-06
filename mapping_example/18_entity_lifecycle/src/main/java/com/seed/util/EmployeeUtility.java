package com.seed.util;

import java.util.List;

import com.seed.entity.Employee;

public class EmployeeUtility {

	public static void display(List<Employee> employees) {
		printStartLine();
		employees.forEach(e -> System.out.println("Id: " + e.getId() + "  salary: " + e.getSalary() + "\tFirst Name: "
				+ e.getFirstName() + "\t:Last Name:" + e.getLastName() + "\tJob: " + e.getJob()));
		printEndLine();
	}

	public static void displayName(List<?> employees) {
		printStartLine();
		/*employees.forEach(
				e -> System.out.println("First Name: " + e.getFirstName() + "\t:Last Name:" + e.getLastName()));*/
		for(Object o: employees) {
			Object[] arr= (Object[]) o;
			System.out.println("First Name: " + arr[0] + "\t:Last Name:" + arr[1]);
		}
		printEndLine();
	}

	public static void displaySalary(List<Employee> employees) {
		printStartLine();
		employees.forEach(e -> System.out.println("First Name: " + e.getSalary()));
		printEndLine();
	}
	
	public static void displayData(List<?> list) {
		printStartLine();
		list.forEach(System.out::println);
		printEndLine();
	}

	public static void printEndLine() {
		System.out.println("_______________________________________________________________________");
	}

	public static void printStartLine() {
		System.out.println("------------------------------------------------------------------------");
	}

}
