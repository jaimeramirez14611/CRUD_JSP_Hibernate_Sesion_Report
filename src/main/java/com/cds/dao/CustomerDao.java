/*
 * Autor: Jaime Ramírez
 * Metodos para el CRUD Customer
 * 23/05/2019
 *
 * */
package com.cds.dao;

import java.util.List;

import com.cds.model.Customer;

public interface CustomerDao {
	
	Long saveCustomer(Customer customer);
	
	Customer findCustomerById(Long id);

	List<Customer> findAllCustomers(); 
	
	Long deleteCustomer(Long id); 
	
	Long updateCustomer(Customer customer);
 }
