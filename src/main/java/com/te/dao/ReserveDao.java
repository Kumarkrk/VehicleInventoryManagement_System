package com.te.dao;

import java.util.List;
import java.util.Map;

import com.te.model.Reservation;

public interface ReserveDao {

    void createReservation(Reservation reservation);

    void cancelReservation(int id);

    Reservation getReservationById(int id);

    void updateReservation(Reservation reservation);

    List<Reservation> getAllReservations();
    Map<String, Long> getReservationReport();
    
    List<Reservation> searchReservations(Integer customerId, Integer vehicleId);
}