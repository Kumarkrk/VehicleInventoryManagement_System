package com.te.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.te.model.FuelType;
import com.te.model.TransmisssionType;
import com.te.model.VehicalStatus;
import com.te.model.Vehicle;
import com.te.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

   @PostMapping("/search")
   public String searchVehicle(@RequestParam(value = "id", defaultValue = "0") int id,@RequestParam("brand") String brand,@RequestParam("model") String model,Model modelObj)
   {
	   try {
	        List<Vehicle> vehicles =
	                vehicleService.searchVehiclesByFilter(id, brand, model);

	        modelObj.addAttribute("vehicles", vehicles);

	        return "vehicle-list";

	    } catch (Exception e) {

	        modelObj.addAttribute("error", "Vehicle search failed: " + e.getMessage());

	        modelObj.addAttribute("id", id);
	        modelObj.addAttribute("brand", brand);
	        modelObj.addAttribute("model", model);

	        return "search-vehicle";
	    }
	   
   }
    
    @GetMapping("/add")
    public String addVehiclePage(Model model) {
    	 model.addAttribute("fuelTypes", FuelType.values());
    	 model.addAttribute("transmissionTypes", TransmisssionType.values());
   	 
    	 

        return "add-vehicle";
    }


   
    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {

        vehicleService.addVehicle(vehicle);

        return "redirect:/vehicles/all";
    }


   
    @GetMapping("/all")
    public String getAllVehicles(Model model) {

        List<Vehicle> vehicles = vehicleService.getVehicles();

        model.addAttribute("vehicles", vehicles);

        return "vehicle-list";
    }


    
    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") int vehicleId) {

        vehicleService.deleteVehicle(vehicleId);

        return "redirect:/vehicles/all";
    }


    @GetMapping("/edit/{id}")
    public String editVehicle(@PathVariable("id") int id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("fuelTypes", FuelType.values());
   	 model.addAttribute("transmissionTypes", TransmisssionType.values());

        return "update-vehicle";
    }
    @GetMapping("/report")
    public String generateReport(Model model) {

        model.addAttribute(
            "vehicles",
            vehicleService.generateInventoryReport()
        );

        return "vehicle-report";
    }
    @PostMapping("/update")
    public String updateVehicle(Vehicle vehicle,Model model) {

        try{
        	vehicleService.updateVehicle(vehicle);
         
        return "redirect:/vehicles/all";
        }
        catch(Exception e)
        {
        	model.addAttribute("error", e);
        	 model.addAttribute("vehicle", vehicle);
             model.addAttribute("fuelTypes", FuelType.values());
             model.addAttribute("transmissionTypes", TransmisssionType.values());
             model.addAttribute("vehicleStatuses", VehicalStatus.values());
        	return "update-vehicle";
        }
    }
}