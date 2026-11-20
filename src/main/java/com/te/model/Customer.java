package com.te.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	@Column(unique = true, nullable = false)
	private String mobileNo;
	@OneToMany(mappedBy = "customerId")
	private List<Reservation> reservation;

	@OneToMany(mappedBy = "customerId")
	private List<Sale> sale;
	
	
	public List<Sale> getSale() {
		return sale;
	}
	public void setSale(List<Sale> sale) {
		this.sale = sale;
	}
	public Customer(String name, String address, String mobileNo, List<Reservation> reservation, List<Sale> sale) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.reservation = reservation;
		this.sale = sale;
	}
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Customer(String name, String address, String mobileNo) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	public Customer() {
		super();
	}
	public Customer(String name, String address, String mobileNo, List<Reservation> reservation) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.reservation = reservation;
	}
	
	

}
