package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Address;
import com.javasampleapproach.springrest.mysql.model.Customer;
import com.javasampleapproach.springrest.mysql.model.CustomerPk;
import com.javasampleapproach.springrest.mysql.repo.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@GetMapping
	public List<Customer> getAllCustomers() {
		CustomerPk cpk = new CustomerPk();
		cpk.setDocumentNumber("111");
		cpk.setDocumentType("CC");
		Customer c = null;
		Optional<Customer> optC = repository.findById(cpk);
		if (!optC.isPresent()) {
			c = new Customer();
			c.setCustomerPK(cpk);
			c.setName("Pepe");
			c.setAge(20);
			c.setActive(true);
			Address a = new Address();
			a.setStreetAddress("Kra  4 # 45 - 54");
			a.setState("Antioquia");
			a.setCity("Medellín");
			c.setAddressHouse(a);
		} else {
			c = optC.get();
			
			Address a = new Address();
			a.setStreetAddress("Kll  34 # 80 - 15");
			a.setState("Antioquia");
			a.setCity("Medellín");
			c.setAddressOffice(a);
		}

		repository.save(c);

		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}
}
