package com.seed.dao;

import java.util.List;

import com.seed.entity.Address;

public interface AddressDao {
	Address save(Address employee);

	Address update(Address employee);

	Address delete(Long addressId);

	Address findById(Long employeeId);

	List<Address> findAll();
}
