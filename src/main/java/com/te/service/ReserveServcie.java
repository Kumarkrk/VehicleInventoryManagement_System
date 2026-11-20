package com.te.service;

import java.util.List;
import java.util.Map;

import com.te.model.Reservation;

public interface ReserveServcie {
     void addReservation(Reservation reservation);
     void cancelReservation(int reserveId);
     List<Reservation> getAllReservations();
     Map<String, Long> generateReservationReport();
     List<Reservation> searchReservations(Integer customerId, Integer vehicleId);
	 Reservation getReservationById(int id);
     
}
