
package com.te.service;

import java.util.List;
import java.util.Map;

import com.te.model.Vehicle;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    void deleteVehicle(int vehicleId);

    String updateVehicle(Vehicle vehicle);

    List<Vehicle> getVehicles();

    

    Map<String, Long> generateInventoryReport();

	Vehicle getVehicleById(int id);

	List<Vehicle> searchVehiclesByFilter(int id, String brand, String model) throws Exception;
}
