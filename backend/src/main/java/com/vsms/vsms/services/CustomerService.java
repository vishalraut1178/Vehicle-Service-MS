package com.vsms.vsms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsms.vsms.entity.Customer;
import com.vsms.vsms.repositories.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo cust_repo;

	public void saveCust(Customer cust) {
		cust_repo.save(cust);
	}

	public List<Customer> getAllCust(){
		return cust_repo.findAll();
	}

	public Optional<Customer> getCust(Long id) {
		return cust_repo.findById(id);
	}

	public Customer updateCust(Customer cust) {
		Customer old_cust = cust_repo.getById(cust.getId());

		old_cust.setName(cust.getName());
		old_cust.setPhone(cust.getPhone());
		old_cust.setEmail(cust.getEmail());
		old_cust.setAddress(cust.getAddress());

		cust_repo.save(old_cust);
		return old_cust;
	}

	public void deleteCust(Long id) {
		cust_repo.deleteById(id);
	}
}
