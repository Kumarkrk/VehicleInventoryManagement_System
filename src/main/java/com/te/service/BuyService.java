package com.te.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.te.model.Sale;
import com.te.model.Vehicle;

public interface BuyService {
	void buyByReservation(int reservationId, BigDecimal amount);
	void buyByDirect(int customerId, int vehicleId, BigDecimal amount);
	List<Sale> getAllSales();
	Map<String, Object> generateSalesReport();
    List<Sale> searchSales(Integer saleId, Integer customerId, Integer vehicleId);
	Vehicle getVehicleById(int vehicleId);	
}
