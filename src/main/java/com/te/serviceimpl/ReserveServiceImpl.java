package com.te.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.dao.CustomerDao;
import com.te.daoimpl.CustomerDaoImpl;
import com.te.daoimpl.ReserveDaoImpl;
import com.te.daoimpl.VehicleDaoImpl;
import com.te.model.Customer;
import com.te.model.Reservation;
import com.te.model.ReservationStatus;
import com.te.model.VehicalStatus;
import com.te.model.Vehicle;
import com.te.service.ReserveServcie;
@Service
public class ReserveServiceImpl implements ReserveServcie {
	
    @Autowired
    VehicleDaoImpl vehicleDao;
    @Autowired
    CustomerDaoImpl customerDao;
    @Autowired
    ReserveDaoImpl reserve;
   
    @Override
    @Transactional(readOnly = true)
    public List<Reservation>  getAllReservations() {

        System.out.println("You have chosen to view all reservations");

        try {
            List<Reservation> reservations = reserve.getAllReservations();

            if (reservations == null || reservations.isEmpty()) {
                System.out.println("No reservations found");
                return null;
            }

            return reservations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Reservation> searchReservations(Integer customerId, Integer vehicleId) {

        System.out.println("You have chosen to search reservations");

        try {
            

          
            if (customerId == null && vehicleId == null) {
                throw new Exception("Enter at least one search field");
            }

            if (customerId != null && customerId < 0 ||
                    vehicleId != null && vehicleId < 0) {
                throw new Exception("IDs cannot be negative");
            }

            List<Reservation> reservations =
                    reserve.searchReservations(customerId, vehicleId);

            if (reservations == null || reservations.isEmpty()) {
                System.out.println("No matching reservations found");
                return null;
            }

           return reservations;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	@Override
	@Transactional
	public void addReservation(Reservation reservation) {

	    System.out.println("You have chosen to reserve the vehicle");

	  
	    int custId = reservation.getCustomerId().getId();

	   
	    int vehicleId = reservation.getVehicleId().getId();

	    
	    BigDecimal amount = reservation.getAmount();

	    try {

	        Customer customer = customerDao.getCustomerById(custId);
	        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);

	      
	        if (customer == null) {
	            throw new Exception("Customer not found");
	        }

	     
	        if (vehicle == null) {
	            throw new Exception("Vehicle not found");
	        }

	        BigDecimal minimumReservationAmount = vehicle.getPrice()
	                .multiply(new BigDecimal("0.10"));

	        if (amount.compareTo(minimumReservationAmount) < 0) {
	            throw new Exception("Minimum reservation amount must be 10% of vehicle price: "
	                    + minimumReservationAmount);
	        }

	        if (amount.compareTo(vehicle.getPrice()) > 0) {
	            throw new Exception("Reservation amount cannot exceed vehicle price");
	        }

	        
	        if (vehicle.getVehicleStatus() != VehicalStatus.AVAILABLE) {
	            throw new Exception("Vehicle is not available for reservation");
	        } else {

	            Reservation reservationObject = reservation;
	            
	            reservation.setReserveStatus(ReservationStatus.CONFIRMED);
	            reserve.createReservation(reservationObject);

	          
	            vehicle.setVehicleStatus(VehicalStatus.RESERVED);
	            vehicleDao.updateVehicle(vehicle);

	            System.out.println("Vehicle reserved successfully");

	        }

	    } catch (Exception e) {

	        System.out.println(e.getMessage());

	    }
	}

	@Override
	@Transactional
	public void cancelReservation(int reservationId) {

	    System.out.println("You have chosen to cancel the reservation");

	 
	    int reserveId = reservationId;

	    try {

	        Reservation reservation = reserve.getReservationById(reserveId);

	      
	        if (reservation == null) {
	            throw new Exception("Enter a valid reservation ID");
	        }

	      
	        if (reservation.getReserveStatus() == ReservationStatus.CANCELLED) {
	            throw new Exception("This reservation is already cancelled");
	        }

	        if (reservation.getReserveStatus() == ReservationStatus.COMPLETED) {
	            throw new Exception("Completed reservation cannot be cancelled");
	        }

	       
	        reservation.setReserveStatus(ReservationStatus.CANCELLED);

	        reserve.updateReservation(reservation);

	       
	        Vehicle vehicle = reservation.getVehicleId();

	        vehicle.setVehicleStatus(VehicalStatus.AVAILABLE);

	        vehicleDao.updateVehicle(vehicle);

	        System.out.println("Reservation cancelled successfully");

	    } catch (Exception e) {

	        System.out.println(e.getMessage());

	    }
	}
	@Override
	public Map<String,Long> generateReservationReport() {

	    Map<String, Long> report = reserve.getReservationReport();

	    System.out.println("\n======================================");
	    System.out.println("        RESERVATION REPORT");
	    System.out.println("======================================");

	    if (report == null || report.isEmpty()) {
	        System.out.println("No reservation information available.");
	        return null;
	    }

	    return report;
	}
	@Override
	public Reservation getReservationById(int id) {
		Reservation reservation=reserve.getReservationById(id);
		
		return reservation;
	}

}
