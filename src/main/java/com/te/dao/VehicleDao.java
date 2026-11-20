package com.te.dao;

import java.util.List;
import java.util.Map;

import com.te.model.Vehicle;

public interface VehicleDao {
	void addVehicle(Vehicle v);
	void updateVehicle(Vehicle vehicle);
	void deleteVehicle(int id);
	List<Vehicle> getAllVehicles();
	Vehicle getVehicleById(int id);
	
	Map<String, Long> getInventoryReport();
	List<Vehicle> searchVehicle(int id, String brand, String model);
	
	

}
