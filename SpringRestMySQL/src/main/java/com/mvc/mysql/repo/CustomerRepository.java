package com.mvc.mysql.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mvc.mysql.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query(value="SELECT * FROM customer WHERE price BETWEEN ?1 AND ?2",nativeQuery=true)
	List<Customer> findBypriceBetween(int min,int max);
	
	
	List<Customer> findByprice(int price);
	
	List<Customer> findByName(String name);
	@Query(value="SELECT * FROM customer WHERE date >CURDATE()",nativeQuery=true)
	List<Customer> findByNotExpired();
	
	
	
	@Query(value="SELECT * FROM customer WHERE date < CURDATE()",nativeQuery=true)
	List<Customer> findByExpired();
	
	@Query(value="SELECT * FROM customer WHERE EXTRACT(MONTH FROM date) =EXTRACT(MONTH FROM CURDATE()) AND year(date)=year(CURDATE()) ",nativeQuery=true)
	List<Customer> findByMonth();
}
