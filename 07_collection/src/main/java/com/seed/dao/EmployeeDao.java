package com.seed.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seed.entitty.Employee;
import com.seed.util.HibernateUtil;

public class EmployeeDao {

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public Employee addEmployee(Employee emp) {
		Transaction tx = null;
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return emp;
	}

	public Employee updateEmployee(Employee emp) {
		Transaction tx = null;
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();
			session.update(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return emp;
	}

	public Employee deleteEmployee(int id) {
		Transaction tx = null;
		Employee emp = null;
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			session.delete(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return emp;
	}

	public List<Employee> getEmployees() {
		return null;
	}
	
	public Employee getEmployee(int id) {
		Transaction tx = null;
		Employee emp = null;
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return emp;
	}

}
