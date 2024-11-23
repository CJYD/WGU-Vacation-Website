package com.d288.cduque10.dao;

import com.d288.cduque10.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")

public interface CustomerRepository extends JpaRepository<Customer, Long> { }