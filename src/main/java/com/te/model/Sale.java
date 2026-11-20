package com.te.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;

	@OneToOne
	@JoinColumn(name = "vehicle_id", unique = true)
	private Vehicle vehicleId;

	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
	private List<Payment> payment;
	@Enumerated(EnumType.STRING)
	private PaymentStaus paymentStatus;
	private LocalDate saleDate;
	@Enumerated(EnumType.STRING)
	private SaleStatus saleStatus;
	
	
	public Sale(Vehicle vehicleId, Customer customerId, PaymentStaus paymentStatus, LocalDate saleDate,
			SaleStatus saleStatus, List<Payment> payment) {
		super();
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.paymentStatus = paymentStatus;
		this.saleDate = saleDate;
		this.saleStatus = saleStatus;
		this.payment = payment;
	}
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Vehicle getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Vehicle vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public PaymentStaus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStaus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public SaleStatus getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(SaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}
	public Sale(Vehicle vehicleId, Customer customerId, PaymentStaus paymentStatus, LocalDate saleDate,
			SaleStatus saleStatus) {
		super();
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.paymentStatus = paymentStatus;
		this.saleDate = saleDate;
		this.saleStatus = saleStatus;
	}
	public Sale() {
		super();
	}
	
	

}
