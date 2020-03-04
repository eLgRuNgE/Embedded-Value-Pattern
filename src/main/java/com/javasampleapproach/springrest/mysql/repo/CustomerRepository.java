package com.javasampleapproach.springrest.mysql.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javasampleapproach.springrest.mysql.model.Customer;
import com.javasampleapproach.springrest.mysql.model.CustomerPk;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerPk> {
	
}
