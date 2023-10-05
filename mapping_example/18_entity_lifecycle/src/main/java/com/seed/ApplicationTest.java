package com.seed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seed.entity.Employee;
import com.seed.service.EmployeeServiceImpl;
import com.seed.util.HibernateUtil;

public class ApplicationTest {

	private static EmployeeServiceImpl empService = new EmployeeServiceImpl();
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {
		//exampleForPersistentState();
		//exampleForPersistentToDetachedState();
		//example3();
		diffOFGetAndPostMethod();
	}

	public static void exampleForTransientState() {
		Employee emp1 = new Employee("Krishna", "Mishra", 99999.0, "CEO"); // transient state

		Employee emp2 = new Employee("William", "Mishra", 10000.0, "Public Accountant");
		emp2.setId(206);
	}
	
	public static void diffOFGetAndPostMethod() {
		Transaction tx = null;
		Employee emp = null;
		try (Session session = sf.openSession();) {
			tx = session.beginTransaction();
			//emp = session.get(Employee.class, 1); // persistent state
			emp = session.load(Employee.class, 1);
			//System.out.println("emp: "+emp.getClass().getName());
			System.out.println(emp.getFirstName()+"  "+emp.getSalary());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	public static void example3() {
		Transaction tx = null;
		Employee emp = null;
		try (Session session = sf.openSession();) {
			tx = session.beginTransaction();
			emp = session.get(Employee.class, 100); // persistent state
			System.out.println(emp.getFirstName()+"  "+emp.getSalary());
			session.clear();
			emp.setSalary(30000.0);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public static void exampleForPersistentState() {
		System.out.println("start");
		Employee emp1 = new Employee("Sameera", "Mishra", 99999.0, "HR"); // transient state

		/*Employee emp2 = new Employee("William", "Mishra", 10000.0, "Public Accountant");
		emp2.setId(206);*/
		
		Transaction tx = null;
		try (Session session = sf.openSession();) {
			tx = session.beginTransaction();
			session.save(emp1);  //from transient -> persistent state
			//emp1.setSalary(5000.0);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		emp1.setSalary(5000.0);
		emp1.setFirstName("Kanhiya");
		
		System.out.println("end of method");
	}
	
	public static void exampleForPersistentToDetachedState() {
		System.out.println("start");
		Employee emp1 = new Employee("Sameera", "Mishra", 99999.0, "HR"); // transient state

		/*Employee emp2 = new Employee("William", "Mishra", 10000.0, "Public Accountant");
		emp2.setId(206);*/
		
		Transaction tx = null;
		try (Session session = sf.openSession();) {
			tx = session.beginTransaction();
			session.save(emp1);  //from transient -> persistent state
			//session.detach(emp1); //persitent -> detached state
			//session.clear();
			session.evict(emp1);
			tx.commit();
			emp1.setFirstName("Abhi");
		
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		System.out.println("end of method");
	}
	
	

}
