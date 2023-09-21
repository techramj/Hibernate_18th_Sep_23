package com.seed.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		System.out.println("Session Factory object created.....");
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
