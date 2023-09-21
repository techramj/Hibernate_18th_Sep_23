package com.seed.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s1 = sf.openSession();

		Employee emp = new Employee(1, "Jack", 1000);
		Transaction transaction = s1.beginTransaction();
		s1.save(emp);
		transaction.commit();
		sf.close();

	}

}
