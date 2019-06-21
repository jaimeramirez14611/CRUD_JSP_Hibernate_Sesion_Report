/*
 * Autor: Jaime Ramírez
 *Mapeo de Objeto Customers
 * 23/05/2019
 *
 * */
package com.cds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
/*Dependencias*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customers")
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customer_id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private String mobile;

	public Customer() {
		// Do Nothing
	}
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Service> services = new ArrayList<Service>(0);

	public Customer(String firstName, String lastName, String email, String mobile) {
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.mobile = mobile;
	}
	public Customer(long customer_id, String first_name, String last_name, String email, String mobile) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.mobile = mobile;
		this.customer_id = customer_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	

}
