package com.te.controller;

import java.math.BigDecimal;
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

import com.te.model.Sale;
import com.te.model.VehicalStatus;
import com.te.model.Vehicle;
import com.te.service.BuyService;

@Controller
@RequestMapping("/sales")
public class BuyController {

    @Autowired
    private BuyService buyService;

    
    @GetMapping("/all")
    public String getAllSales(Model model) {

        List<Sale> sales = buyService.getAllSales();

        model.addAttribute("sales", sales);

        return "sales-list";
    }

   
    @GetMapping("/search")
    public String searchSales(

            @RequestParam(value = "saleId", required = false)
            Integer saleId,

            @RequestParam(value = "customerId", required = false)
            Integer customerId,

            @RequestParam(value = "vehicleId", required = false)
            Integer vehicleId,

            Model model) {

        List<Sale> sales = buyService.searchSales(
                saleId,
                customerId,
                vehicleId
        );

        model.addAttribute("sales", sales);

        return "sales-list";
    }

   
    @GetMapping("/direct")
    public String showDirectPurchaseForm() {

        return "direct-purchase";
    }

    
    @PostMapping("/direct")
    public String buyByDirect(

            @RequestParam("customerId") int customerId,

            @RequestParam("vehicleId") int vehicleId,

            @RequestParam("amount") BigDecimal amount,

            RedirectAttributes redirectAttributes) {

        try {

            buyService.buyByDirect(
                    customerId,
                    vehicleId,
                    amount
            );

            redirectAttributes.addFlashAttribute(
                    "message",
                    "Vehicle purchased successfully"
            );

            return "redirect:/sales/all";

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    e.getMessage()
            );

            return "redirect:/sales/direct";
        }
    }

   
    @GetMapping("/reservation")
    public String showReservationPurchaseForm() {

        return "reservation-purchase";
    }

   
    @PostMapping("/reservation")
    public String buyByReservation(

            @RequestParam("reservationId") int reservationId,

            @RequestParam("amount") BigDecimal amount,

            RedirectAttributes redirectAttributes) {

        try {

            buyService.buyByReservation(
                    reservationId,
                    amount
            );

            redirectAttributes.addFlashAttribute(
                    "message",
                    "Reserved vehicle purchased successfully"
            );

            return "redirect:/sales/all";

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute(
                    "error",
                    e.getMessage()
            );

            return "redirect:/sales/reservation";
        }
    }
    @GetMapping("/getVehicleAmount")
    public String getVehicleAmount(
            @RequestParam("vehicleId") int vehicleId,
            Model model) {

        Vehicle vehicle = buyService.getVehicleById(vehicleId);

        model.addAttribute("vehicleId", vehicleId);

        if (vehicle == null) {
            model.addAttribute("error", "Vehicle not found");
            return "direct-purchase";
        }

        if (vehicle.getVehicleStatus() == VehicalStatus.RESERVED) {

            model.addAttribute(
                    "error",
                    "This vehicle is already reserved. You cannot purchase it directly."
            );

            return "direct-purchase";
        }

        if (vehicle.getVehicleStatus() == VehicalStatus.SOLD) {

            model.addAttribute(
                    "error",
                    "This vehicle has already been sold."
            );

            return "direct-purchase";
        }

        if (vehicle.getVehicleStatus() != VehicalStatus.AVAILABLE) {

            model.addAttribute(
                    "error",
                    "This vehicle is not available for purchase."
            );

            return "direct-purchase";
        }

        model.addAttribute("vehicleAmount", vehicle.getPrice());

        model.addAttribute(
                "message",
                "Vehicle is available. You can proceed with the purchase."
        );

        return "direct-purchase";
    }
  
    @GetMapping("/report")
    public String generateSalesReport(Model model) {

        Map<String, Object> report =
                buyService.generateSalesReport();

        model.addAttribute("report", report);

        return "sales-report";
    }
}
