/*
 * Autor: Jaime Ramírez
 *Mapeo del objeto Service
 * 23/05/2019
 *
 * */
package com.cds.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="services")
public class Service implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_id")
	private Long service_id;
	@Column(name="service_name")
	private String service_name;
	@Column(name="service_code")
	private String service_code;
	@Column(name="service_description")
	private String service_description;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
	public Service() {
	}
	
	public Service(String service_name, String service_code, String service_description, Customer customer) {
		this.service_name = service_name;
		this.service_code = service_code;
		this.service_description = service_description;
		this.customer = customer;
	}
	
	public Service(Long service_id, String service_name, String service_code, String service_description,
			Customer customer) {
		
		this.service_id = service_id;
		this.service_name = service_name;
		this.service_code = service_code;
		this.service_description = service_description;
		this.customer = customer;
	}

	public Long getService_id() {
		return service_id;
	}
	public void setService_id(Long service_id) {
		this.service_id = service_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public String getService_description() {
		return service_description;
	}
	public void setService_description(String service_description) {
		this.service_description = service_description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
