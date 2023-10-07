package com.seed.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seed.entity.Address;
import com.seed.util.HibernateUtil;

public class AddressDaoImpl implements AddressDao{
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Address save(Address address) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession();) {
			tx = session.beginTransaction();
			session.persist(address);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public Address update(Address employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address delete(Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findById(Long addressId) {
		Address address = null;
		try (Session session = sessionFactory.openSession();) {

			address = session.get(Address.class, addressId);
			address.getEmployee().getName();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
