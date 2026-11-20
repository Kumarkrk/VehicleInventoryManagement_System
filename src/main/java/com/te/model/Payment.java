package com.te.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private PaymentStaus paymentStatus;
	private BigDecimal amount;
	private BigDecimal dueAmount; 
	private LocalDate paymnetDate;
	
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicleId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PaymentStaus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStaus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}
	public LocalDate getPaymnetDate() {
		return paymnetDate;
	}
	public void setPaymnetDate(LocalDate paymnetDate) {
		this.paymnetDate = paymnetDate;
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
	public Sale getSale() {
	    return sale;
	}

	public void setSale(Sale sale) {
	    this.sale = sale;
	}
	public Payment(PaymentStaus paymentStatus, BigDecimal amount, BigDecimal dueAmount, LocalDate paymnetDate,
			Vehicle vehicleId, Customer customerId) {
		super();
		this.paymentStatus = paymentStatus;
		this.amount = amount;
		this.dueAmount = dueAmount;
		this.paymnetDate = paymnetDate;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
	}
	public Payment() {
		super();
	}
	
	
	
	

}
