package com.mvc.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mvc.mysql.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
