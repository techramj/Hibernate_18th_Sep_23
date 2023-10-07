package com.seed.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seed.entity.Employee;
import com.seed.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Employee save(Employee employee) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession();) {
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee update(Employee emp) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession();) {
			tx = session.beginTransaction();
			session.update(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee delete(Integer employeeId) {
		Transaction tx = null;
		Employee emp = null;
		try (Session session = sessionFactory.openSession();) {
			tx = session.beginTransaction();
			emp = session.get(Employee.class, employeeId);
			session.delete(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee findById(Integer employeeId) {
		Transaction tx = null;
		Employee emp = null;
		try (Session session = sessionFactory.openSession();) {
			tx = session.beginTransaction();
			emp = session.get(Employee.class, employeeId);
			//System.out.println(emp.getAddress());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		Transaction tx = null;
		Employee emp = null;
		try (Session session = sessionFactory.openSession();) {
			tx = session.beginTransaction();
			Query query = session.createQuery("select e from Employee e");
			employees = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByFirstName(String firstName) {
		String hql = "from Employee e where e.firstName=:name";
		try (Session session = sessionFactory.openSession();) {
			Query query = session.createQuery(hql);
			query.setParameter("name", firstName);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Employee>();
	}

	@Override
	public List<Employee> findEmployeeByLastName(String lastName) {
		try (Session session = sessionFactory.openSession();) {
			TypedQuery<Employee> query = session.getNamedQuery("findByLastName");
			query.setParameter("name", lastName);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Employee>();
	}

}
