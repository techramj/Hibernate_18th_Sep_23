package com.seed.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.seed.entity.Employee;
import com.seed.entity.Manager;
import com.seed.entity.SalesPerson;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration cfg = new Configuration();
		
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(SalesPerson.class);
		cfg.addAnnotatedClass(Manager.class);
		
		
		sessionFactory = cfg.buildSessionFactory();
		System.out.println("Session Factory object created.....");
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
