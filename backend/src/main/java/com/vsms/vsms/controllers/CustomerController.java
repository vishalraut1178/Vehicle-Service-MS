package com.vsms.vsms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsms.vsms.entity.Customer;
import com.vsms.vsms.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService cust_serv;

	@PostMapping("/save")
	public String saveCust(@RequestBody Customer cust) {
		cust_serv.saveCust(cust);
		return "Customer saved successfully!";
	}

	@GetMapping("/getAll")
	public List<Customer> getAll(){
		return cust_serv.getAllCust();
	}

	@GetMapping("/get/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return cust_serv.getCust(id);
	}

	@PutMapping("/update")
	public Customer updateCust(@RequestBody Customer cust) {
		return cust_serv.updateCust(cust);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCust(@PathVariable Long id) {
		cust_serv.deleteCust(id);
		return "Customer deleted successfully!";
	}

}
