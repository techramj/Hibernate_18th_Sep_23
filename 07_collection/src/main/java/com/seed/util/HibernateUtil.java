package com.seed.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.seed.entitty.Employee;
import com.seed.entitty.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration cfg = new Configuration();
		
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Student.class);
		
		sessionFactory = cfg.buildSessionFactory();
		System.out.println("Session Factory object created.....");
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
