package com.mvc.mysql.model;






import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private int price;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date; 
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer() {
	}

	public Customer(String name, int price,Date date) {
		this.name = name;
		this.price = price;
		this.date=date;
		
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getprice() {
		return this.price;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", price=" + price +  " ]";
	}



	

	
}
