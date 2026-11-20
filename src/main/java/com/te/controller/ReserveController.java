
package com.te.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.te.model.Customer;
import com.te.model.Reservation;
import com.te.model.ReservationStatus;
import com.te.model.Vehicle;
import com.te.service.CustomerService;
import com.te.service.ReserveServcie;
import com.te.service.VehicleService;
import com.te.serviceimpl.CustomerServiceImpl;
import com.te.serviceimpl.VehicleServiceImpl;

@Controller
@RequestMapping("/reservations")
public class ReserveController {

    @Autowired
    private ReserveServcie reserveService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private CustomerService customerService;

   
    @GetMapping("/all")
    public String getAllReservations(Model model) {

        List<Reservation> reservations =
                reserveService.getAllReservations();

        model.addAttribute("reservations", reservations);

        return "reservation-list";
    }

  
    @GetMapping("/search")
    public String searchReservations(
            @RequestParam(value="customerId", required = false) Integer customerId,
            @RequestParam(value="vehicleId",required = false) Integer vehicleId,
            Model model) {

        List<Reservation> reservations =
                reserveService.searchReservations(customerId, vehicleId);

        model.addAttribute("reservations", reservations);

        return "reservation-list";
    }

   
    @PostMapping("/check")
    public String checkReservationAmount(
            @RequestParam("customerId") int customerId,
            @RequestParam("vehicleId") int vehicleId,
            Model model) {

        Vehicle vehicle=vehicleService.getVehicleById(vehicleId);
        Customer customer=customerService.getCustomerById(customerId);

        if (vehicle == null) {
            model.addAttribute("error", "Vehicle not found");
            return "add-reservation";
        }
        if(customer==null)
        {
        	 model.addAttribute("error", "Customer not found");
             return "add-reservation";
        }
        BigDecimal amount = vehicle.getPrice()
                .multiply(new BigDecimal("0.10"));

        model.addAttribute("vehicle", vehicle);
        model.addAttribute("customerId", customerId);
        model.addAttribute("reservationAmount", amount);
        model.addAttribute("vehicle", vehicle);
        return "add-reservation";
    }

    @GetMapping("/add")
    public String showAddReservationForm() {
        return "add-reservation";
    }
    @PostMapping("/add")
    public String addReservation(
            @RequestParam("customerId") int customerId,
            @RequestParam("vehicleId") int vehicleId,
            @RequestParam("amount") BigDecimal amount,
            RedirectAttributes redirectAttributes) {

        Customer customer = customerService.getCustomerById(customerId);
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);

        if (customer == null || vehicle == null) {
            redirectAttributes.addFlashAttribute(
                    "error", "Invalid customer or vehicle");
            return "redirect:/reservations/add";
        }

        Reservation reservation = new Reservation();

        reservation.setCustomerId(customer);
        reservation.setVehicleId(vehicle);
        reservation.setAmount(amount);
        reservation.setReserveStatus(ReservationStatus.CONFIRMED);
        reservation.setReservationDate(LocalDate.now());

        reserveService.addReservation(reservation);

        redirectAttributes.addFlashAttribute(
                "message", "Reservation added successfully");

        return "redirect:/reservations/all";
    }

   
    @PostMapping("/cancel")
    public String cancelReservation(
            @RequestParam("id") int reserveId,
            RedirectAttributes redirectAttributes) {

        reserveService.cancelReservation(reserveId);

        redirectAttributes.addFlashAttribute(
                "message", "Reservation cancelled successfully");

        return "redirect:/reservations/all";
    }

  
    @GetMapping("/report")
    public String generateReservationReport(Model model) {

        Map<String, Long> report =
                reserveService.generateReservationReport();

        model.addAttribute("report", report);

        return "reservation-report";
    }
    @PostMapping("/getReserveAmount")
    public String getReservedAmountById(
            @RequestParam("reservationId") int id,
            Model model) {

        Reservation reservation = reserveService.getReservationById(id);

        if (reservation == null) {
            model.addAttribute("error", "Reservation not found");
            return "reservation-purchase";
        }

        BigDecimal vehiclePrice = reservation.getVehicleId().getPrice();
        BigDecimal reservedAmount = reservation.getAmount();

        BigDecimal remainingAmount =
                vehiclePrice.subtract(reservedAmount);

        model.addAttribute("reservationId", id);
        model.addAttribute("vehiclePrice", vehiclePrice);
        model.addAttribute("reservedAmount", reservedAmount);
        model.addAttribute("remainingAmount", remainingAmount);

        return "reservation-purchase";
    }
}
