package com.seed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.seed.entity.Employee;
import static com.seed.util.EmployeeUtility.*;
import com.seed.util.HibernateUtil;

public class HQLTest {

	// whole persistent object into the memory
	public static void hqlExample1(Session session) {
		String hql = "from Employee e";
		Query query = session.createQuery(hql);
		List<Employee> list = query.getResultList();
		display(list);
	}

	// pagination: pageno:1 pagesize:5
	public static void hqlExample2(Session session, int pageno, int pagesize) {
		String hql = "from Employee e";
		Query query = session.createQuery(hql);

		query.setFirstResult((pageno - 1) * pagesize);
		query.setMaxResults(pagesize);

		List<Employee> list = query.getResultList();
		display(list);
	}

	// Hql select clause : when you want to select few attribute
	public static void hqlExample3(Session session) {
		String hql = "select e.firstName from Employee e";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		displayData(list);
	}

	// Hql select clause : when you want to select few attribute
	public static void hqlExample4(Session session) {
		String hql = "select e.firstName, e.lastName from Employee e";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		displayName(list);
	}

	// where clause
	public static void hqlExample5(Session session) {
		String hql = "select e from Employee e where e.salary>20000";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		display(list);
	}

	// order by clause
	public static void hqlExample6(Session session) {
		String hql = "select e from Employee e where e.salary>20000 order by e.salary";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		display(list);
	}

	// query by paramter
	public static void hqlExample7(Session session, double salary, String job) {
		String hql = "select e from Employee e where e.salary>=:salary and e.job=:j order by e.salary";
		Query query = session.createQuery(hql);
		query.setParameter("salary", salary);
		query.setParameter("j", job);
		List list = query.getResultList();
		display(list);
	}
	

	//aggregate methods

	public static void hqlAggregateExample1(Session session) {
		String hql = "select count(e) from Employee e";
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.println(list.get(0));
	}
	
	//nth highest salary
	public static void printNthHighestSalary(Session session, int n) {
		String hql ="select salary from Employee e order by salary desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(n-1);
		query.setMaxResults(1);
		List list = query.list();
		System.out.println(list.get(0));
	}
	
	// nth highest salary using native sql query
	public static void printNthHighestSalary1(Session session, int n) {
		String sql = "SELECT salary FROM(\n" + "SELECT salary, dense_rank() OVER(ORDER BY salary DESC) AS RANK\n"
				+ "FROM emp\n" + ") WHERE RANK=:rank";
		Query query = session.createSQLQuery(sql);
		query.setParameter("rank", n);
		BigDecimal nthHightestSal = (BigDecimal) query.uniqueResult();
		System.out.println(nthHightestSal);
	}

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try (Session session = sf.openSession()) {
			hqlAggregateExample1(session);
			// hqlExample1(session);

			// hqlExample2(session, 1, 5);
			// hqlExample2(session, 2,5 );

			// hqlExample6(session);

			//hqlExample7(session, 3000, "ST_CLERK");
			//hqlExample7(session, 14000, "SA_MAN");
			
			printNthHighestSalary1(session,5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
