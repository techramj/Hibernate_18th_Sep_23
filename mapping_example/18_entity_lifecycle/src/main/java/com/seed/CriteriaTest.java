package com.seed;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.seed.entity.Employee;
import static com.seed.util.EmployeeUtility.*;
import com.seed.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class CriteriaTest {

	// get all records
	public static void example1(Session session) {
		Criteria criteria = session.createCriteria(Employee.class);
		List list = criteria.list();
		display(list);
	}

	// get specific record
	public static void example2(Session session, int id) {
		Criteria criteria = session.createCriteria(Employee.class);
		Criteria add = criteria.add(Restrictions.eq("id", Integer.valueOf(id)));

		Employee e = (Employee) criteria.uniqueResult();
		System.out.println(e.getFirstName() + "   " + e.getLastName());
	}

	// get specific record
	public static void example3(Session session, int id) {
		Criteria criteria = session.createCriteria(Employee.class)
				.add(Restrictions.eq("id", Integer.valueOf(id)));

		Employee e = (Employee) criteria.uniqueResult();
		System.out.println(e.getFirstName() + "   " + e.getLastName());
	}
	
	// get all records
	public static void example4(Session session, int pageno, int pagesize) {
		List list = session.createCriteria(Employee.class)
				.setFirstResult((pageno - 1) * pagesize)
				.setMaxResults(pagesize)
				.list();
		display(list);
	}
	
	// like operator
	public static void example5(Session session, String pattern) {
		List list = session.createCriteria(Employee.class)
				.add(Restrictions.like("lastName", pattern))
				.list();

		display(list);
	}
	
	//aggregate method count whose lastName contain letter e;
	public static void example6(Session session) {
		long count = (long) session.createCriteria(Employee.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.like("lastName", "%e%"))
				.uniqueResult();
		System.out.println(count);
	}
	
	

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try (Session session = sf.openSession()) {
			//example2(session,100);
			//example3(session,101);
			
			//example4(session, 1,5);
			//example4(session, 2,5);
			//example4(session, 3,5);
			
			//example5(session,"A%");
			//example5(session,"B%");
			
			example6(session);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
