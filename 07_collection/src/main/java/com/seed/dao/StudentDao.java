package com.seed.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seed.entitty.Student;
import com.seed.util.HibernateUtil;

public class StudentDao {
	
	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public Student addStudent(Student student) {
		Transaction tx = null;
		try (Session session = factory.openSession();) {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		return student;
	}

}
