package com.seed;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.seed.entity.Employee;

public class Application {
	
	public static void main(String[] args) {
		//session factory object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
	
		System.out.println("sessionfactory object created");
		
		
		Session session = sf.openSession();
		Employee e1 = new Employee(3, "sam", 2000.0);
		Transaction tx = session.beginTransaction();
		session.save(e1);
		tx.commit();
		
		sf.close();
	}
	
	

}
