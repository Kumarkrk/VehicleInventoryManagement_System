package com.te.model;

import java.math.BigDecimal;
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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="brand must not to be null")
	private String brand;
	@NotBlank(message="model name must not to be null")
	private String model;
	@Enumerated(EnumType.STRING)
	private FuelType fuelType;
	@Enumerated(EnumType.STRING)
	private TransmisssionType transType;
	@Min(1886)
	private Integer manufacturedYear;
	private String colour;
	@OneToMany(mappedBy = "vehicleId")
	private List<Reservation> reservation;
	@Positive
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private VehicalStatus vehicleStatus= VehicalStatus.AVAILABLE;;
	
	
	
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	public VehicalStatus getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(VehicalStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public TransmisssionType getTransType() {
		return transType;
	}
	public void setTransType(TransmisssionType transType) {
		this.transType = transType;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getManufacturedYear() {
	    return manufacturedYear;
	}

	public void setManufacturedYear(Integer manufacturedYear) {
	    this.manufacturedYear = manufacturedYear;
	}
	public Vehicle() {
		super();
	}
	public Vehicle(
	        String brand,
	        String model,
	        FuelType fuelType,
	        TransmisssionType transType,
	        Integer manufacturedYear,
	        String colour,
	        BigDecimal price,
	        VehicalStatus vehicleStatus) {

	    this.brand = brand;
	    this.model = model;
	    this.fuelType = fuelType;
	    this.transType = transType;
	    this.manufacturedYear = manufacturedYear;
	    this.colour = colour;
	    this.price = price;
	    this.vehicleStatus = vehicleStatus;
	}
	
	

}
