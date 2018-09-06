package com.mvc.mysql.controller;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.mysql.model.Customer;
import com.mvc.mysql.repo.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {


	@Autowired
	CustomerRepository repository;

	//GET ALL PRODUCT DATA
	@GetMapping("/products")
	public List<Customer> getAllCustomers() {
		System.out.println("Get all Products...");

		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);
		
		return customers;
	}

	@PostMapping(value = "/products/create")
	public Customer postCustomer(@RequestBody Customer customer) {

		Customer _customer = repository.save(new Customer(customer.getName(), customer.getprice(),customer.getDate()));
		return _customer;
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/products/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		repository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "products/price/{price}")
	public List<Customer> findByprice(@PathVariable int price) {
		
			
			List<Customer> customers = repository.findByprice(price);
	
			return customers;
	}
	
	@GetMapping(value = "products/month")
	public List<Customer> findByMonth() {
		
			List<Customer> customers = repository.findByMonth();
			return customers;
	
	}
	
	@GetMapping(value = "products/expired/")
	public List<Customer> findByExpired() {
		
			
			List<Customer> customers = repository.findByExpired();
			return customers;
	
	}
	@GetMapping(value = "products/not_expired/")
	public List<Customer> findByNotExpired() {
		
			
			List<Customer> customers = repository.findByNotExpired();
			return customers;

	}
	
	
	
		
	@GetMapping(value = "products/price_between/{min}/{max}")
	public List<Customer> findBypriceBetween(@PathVariable int min,@PathVariable int max) {
		
			
			List<Customer> customers = repository.findBypriceBetween(min,max);
			return customers;
	}
//		
	@GetMapping(value = "products/name/{name}")
	public List<Customer> findByName(@PathVariable String name) {

		List<Customer> customers = repository.findByName(name);
		return customers;
	}

	
	@PutMapping("/products/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Customer> customerData = repository.findById(id);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setName(customer.getName());
			_customer.setprice(customer.getprice());
			
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
