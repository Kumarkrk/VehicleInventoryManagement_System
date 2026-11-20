package com.te.serviceimpl;

import java.math.BigDecimal;

import java.time.Year;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.te.dao.VehicleDao;
import com.te.model.FuelType;
import com.te.model.TransmisssionType;
import com.te.model.VehicalStatus;
import com.te.model.Vehicle;
import com.te.service.VehicleService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final LocalSessionFactoryBean sessionFactory;

	

    @Autowired
    private VehicleDao vehicleDao;


	VehicleServiceImpl(LocalSessionFactoryBean sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

   
    private String readString(String fieldName) {

        while (true) {

           String value=fieldName;

            if (value == null || value.trim().isEmpty()) {
                System.out.println(fieldName + " cannot be null or empty. Please enter again.");
            } else {
                return value.trim();
            }
        }
    }

   
//    private int readInteger(String fieldName) {
//
//        while (true) {
//
//            System.out.println("Enter " + fieldName + ":");
//            String value = sc.nextLine();
//
//            try {
//                int number = Integer.parseInt(value);
//
//                if (number <= 0) {
//                    System.out.println(fieldName + " must be greater than zero.");
//                } else {
//                    return number;
//                }
//
//            } catch (NumberFormatException e) {
//                System.out.println("Please enter a valid integer.");
//            }
//        }
//    }

  
//    private BigDecimal readPrice() {
//
//        while (true) {
//
//            System.out.println("Enter vehicle price:");
//            String value = sc.nextLine();
//
//            try {
//                BigDecimal price = new BigDecimal(value);
//
//                if (price.compareTo(BigDecimal.ZERO) <= 0) {
//                    System.out.println("Price must be greater than zero.");
//                } else {
//                    return price;
//                }
//
//            } catch (NumberFormatException e) {
//                System.out.println("Please enter a valid price.");
//            }
//        }
//    }

  
//    private Integer readManufacturedYear() {
//
//        while (true) {
//
//           
//
//            try {
//                int year = Integer.parseInt(value);
//
//                if (year < 1886 || year > Year.now().getValue()) {
//                    System.out.println("Enter a valid manufacturing year.");
//                } else {
//                    return year;
//                }
//
//            } catch (NumberFormatException e) {
//                System.out.println("Please enter a valid year.");
//            }
//        }
//    }
//
//  
//    private FuelType readFuelType() {
//
//        while (true) {
//
//            System.out.println("Select fuel type:");
//            System.out.println("1. Petrol");
//            System.out.println("2. Diesel");
//            System.out.println("3. CNG");
//            System.out.println("4. Electric");
//
//            int choice = readInteger("fuel type choice");
//
//            switch (choice) {
//
//                case 1:
//                    return FuelType.PETROL;
//
//                case 2:
//                    return FuelType.DIESEL;
//
//                case 3:
//                    return FuelType.CNG;
//
//                case 4:
//                    return FuelType.ELECTRIC;
//
//                default:
//                    System.out.println("Invalid fuel type choice. Please select 1 to 4.");
//            }
//        }
//    }
//
//  
//    private TransmisssionType readTransmissionType() {
//
//        while (true) {
//
//            System.out.println("Select transmission type:");
//            System.out.println("1. Manual");
//            System.out.println("2. Automatic");
//
//            int choice = readInteger("transmission choice");
//
//            switch (choice) {
//
//                case 1:
//                    return TransmisssionType.MANUAL;
//
//                case 2:
//                    return TransmisssionType.AUTOMATIC;
//
//                default:
//                    System.out.println("Invalid transmission choice. Please select 1 or 2.");
//            }
//        }
//    }

  
    @Override
    @Transactional
    public void addVehicle(Vehicle vehicle) {

        try {

            System.out.println("You have chosen to add vehicle details.");


            vehicleDao.addVehicle(vehicle);

            System.out.println("Vehicle added successfully!");

        } catch (Exception e) {
            System.out.println("Unable to add vehicle: " + e.getMessage());
        }
    }

  
    @Override
    @Transactional
    public void deleteVehicle(int id) {

        try {



            Vehicle vehicle = vehicleDao.getVehicleById(id);

            if (vehicle == null) {
                throw new IllegalArgumentException(
                        "Vehicle not found with ID: " + id);
            }

            if (vehicle.getVehicleStatus() != VehicalStatus.AVAILABLE) {
                throw new IllegalStateException(
                        "Only available vehicles can be deleted.");
            }

            vehicleDao.deleteVehicle(id);

            System.out.println("Vehicle deleted successfully!");

        } catch (Exception e) {
            System.out.println("Unable to delete vehicle: " + e.getMessage());
        }
    }

  
   

           
    	@Override
    	@Transactional
    	public String updateVehicle(Vehicle vehicle) {

    	    if (vehicle == null) {
    	        throw new IllegalArgumentException("Vehicle cannot be null");
    	    }

    	    Vehicle existingVehicle =
    	            vehicleDao.getVehicleById(vehicle.getId());

    	    if (existingVehicle == null) {
    	        throw new IllegalArgumentException(
    	                "Vehicle not found with ID: " + vehicle.getId());
    	    }

    	    existingVehicle.setBrand(vehicle.getBrand());
    	    existingVehicle.setModel(vehicle.getModel());
    	    existingVehicle.setFuelType(vehicle.getFuelType());
    	    existingVehicle.setTransType(vehicle.getTransType());
    	    existingVehicle.setManufacturedYear(vehicle.getManufacturedYear());
    	    existingVehicle.setColour(vehicle.getColour());
    	    existingVehicle.setPrice(vehicle.getPrice());

    	    return "Vehicle updated successfully";
    	}
         

    

  
    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles() {

        try {

            List<Vehicle> vehicles = vehicleDao.getAllVehicles();

            if (vehicles == null || vehicles.isEmpty()) {
                System.out.println("No vehicle records found.");
                return null;
            }
            return vehicles;


        } catch (Exception e) {
            System.out.println("Unable to display vehicles: " + e.getMessage());
        }
		return null;
    }

   
    @Override
    @Transactional(readOnly = true)
   
    public Vehicle getVehicleById(int id) {

        Vehicle vehicle = vehicleDao.getVehicleById(id);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }

        return vehicle;
    }
    @Override
    @Transactional(readOnly = true)
    public Map<String, Long> generateInventoryReport() {
        return vehicleDao.getInventoryReport();
    }


	@Override
	public List<Vehicle> searchVehiclesByFilter(int id, String brand, String model) throws Exception {
		System.out.println("you are choosed to search vehicles ");

		List<Vehicle> vehicleList=vehicleDao.searchVehicle(id,brand,model);
		return vehicleList;
		
	}


	
}
