package com.te.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private ReservationStatus reserveStatus;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicleId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	@Positive(message="amount must not be negative")
	private BigDecimal amount;
	@PastOrPresent(message="date must not be in future")
	private LocalDate reservationDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ReservationStatus getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(ReservationStatus reserveStatus) {
		this.reserveStatus = reserveStatus;
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
	
	
	public Reservation(ReservationStatus reserveStatus,  Vehicle vehicleId, Customer customerId) {
		super();
		this.reserveStatus = reserveStatus;
		
		this.vehicleId = vehicleId;
		this.customerId = customerId;
	}
	public Reservation(ReservationStatus reservationSucessfull, int custId, int vehicleId2, BigDecimal amount) {
		
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Reservation(ReservationStatus reserveStatus, Vehicle vehicleId, Customer customerId,
			@Positive(message = "amount must not be negative") BigDecimal amount,
			@PastOrPresent(message = "date must not be in future") LocalDate reservationDate) {
		super();
		this.reserveStatus = reserveStatus;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.amount = amount;
		this.reservationDate = reservationDate;
	}
	public Reservation() {
	    super();
	}
	
	
	
	

}
