package com.javasampleapproach.springrest.mysql.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7483798050115088695L;

	@EmbeddedId
	private CustomerPk customerPK;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "active")
	private boolean active;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="streetAddress",
                           column=@Column(name="street_address_house")),
        @AttributeOverride(name="state",
                           column=@Column(name="state_house")),
        @AttributeOverride(name="city",
                           column=@Column(name="city_house"))
    })
	private Address addressHouse;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="streetAddress",
                           column=@Column(name="street_address_office")),
        @AttributeOverride(name="state",
                           column=@Column(name="state_office")),
        @AttributeOverride(name="city",
                           column=@Column(name="city_office"))
    })
	private Address addressOffice;

	public Customer() {
	}

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.active = false;
	}

	public CustomerPk getCustomerPK() {
		return customerPK;
	}
	
	public void setCustomerPK(CustomerPk customerPK) {
		this.customerPK = customerPK;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	public void setAddressHouse(Address addressHouse) {
		this.addressHouse = addressHouse;
	}
	
	public Address getAddressHouse() {
		return addressHouse;
	}
	
	public void setAddressOffice(Address addressOffice) {
		this.addressOffice = addressOffice;
	}
	
	public Address getAddressOffice() {
		return addressOffice;
	}
}
