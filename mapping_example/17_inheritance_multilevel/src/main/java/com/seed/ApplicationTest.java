package com.seed;

import java.util.List;

import com.seed.dao.EmployeeDao;
import com.seed.dao.EmployeeDaoImpl;
import com.seed.entity.Ceo;
import com.seed.entity.Employee;
import com.seed.entity.Manager;
import com.seed.entity.SalesPerson;
import com.seed.service.EmployeeServiceImpl;


public class ApplicationTest {

	public static void main(String[] args) {

		addExample();
		fetchExample();
	}

	public static void addAddress() {
		// AddressService
	}

	public static void fetchExample() {
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Employee> list1 = dao.findAll();
		display(list1);
		
		List<Employee> list2 = dao.findAllManager();
		display(list2);
		
		List<Employee> list3 = dao.findAllSalesPerson();
		display(list3);
		
		List<Employee> list4 = dao.findAllCeo();
		display(list4);
		
	}
	
	public static void display(List<Employee> list) {
		
		int size = list.size();
		if(size == 0) {
			return;
		}
		System.out.println();
		System.out.println("class Name: "+list.get(0).getClass().getName());
		System.out.println("==================");
		for(Employee e:list) {
			System.out.println("Id: "+e.getId());
			System.out.println("Name: "+e.getName());
			System.out.println("salary: "+e.getSalary());
			System.out.println();
		}
		
		System.out.println("_________________________________________");
	}

	public static void addExample() {
		EmployeeServiceImpl empService = new EmployeeServiceImpl(); // loose coupling

		Employee emp1 = new Employee("Jack", 5000.0);
		Employee emp2 = new SalesPerson("Sam", 8000.0, 20000, 1);
		Employee emp3 = new Manager("Jessica", 10000.0, 1000);

		Employee emp4 = new Ceo("Jackie", 15000.0, 1000, 20);

		empService.addEmployee(emp1);
		empService.addEmployee(emp2);
		empService.addEmployee(emp3);
		empService.addEmployee(emp4);

	}

}
