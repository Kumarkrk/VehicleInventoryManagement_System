package com.te.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.daoimpl.BuyDaoImpl;
import com.te.daoimpl.CustomerDaoImpl;
import com.te.daoimpl.ReserveDaoImpl;
import com.te.daoimpl.VehicleDaoImpl;

import com.te.model.Customer;
import com.te.model.Payment;
import com.te.model.PaymentStaus;
import com.te.model.Reservation;
import com.te.model.ReservationStatus;
import com.te.model.Sale;
import com.te.model.SaleStatus;
import com.te.model.Vehicle;
import com.te.model.VehicalStatus;

import com.te.service.BuyService;

@Service
public class BuyServiceImpl implements BuyService {

   

    @Autowired
    ReserveDaoImpl reserveDao;

    @Autowired
    VehicleDaoImpl vehicleDao;

    @Autowired
    CustomerDaoImpl customerDao;

    @Autowired
    BuyDaoImpl buyDao;


   

    @Override
    @Transactional
    public void buyByReservation(int reserveId, BigDecimal reserveAmount) {

        Reservation reservation =
                reserveDao.getReservationById(reserveId);

        if (reservation == null) {
            throw new IllegalArgumentException("Invalid reservation ID");
        }

        if (reservation.getReserveStatus() != ReservationStatus.CONFIRMED) {
            throw new IllegalArgumentException(
                    "This reservation is not confirmed");
        }

        Vehicle vehicle = reservation.getVehicleId();
        Customer customer = reservation.getCustomerId();

        if (vehicle == null || customer == null) {
            throw new IllegalArgumentException(
                    "Vehicle or customer details not found");
        }

        if (vehicle.getVehicleStatus() != VehicalStatus.RESERVED) {
            throw new IllegalArgumentException(
                    "Vehicle is not in reserved status");
        }

        if (reserveAmount == null ||
                vehicle.getPrice() == null ||
                reservation.getAmount() == null) {
            throw new IllegalArgumentException(
                    "Payment amount or vehicle price is missing");
        }

       
        BigDecimal dueAmount = vehicle.getPrice()
                .subtract(reservation.getAmount());

        if (dueAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Invalid remaining payment amount");
        }

        if (reserveAmount.compareTo(dueAmount) != 0) {
            throw new IllegalArgumentException(
                    "Incorrect payment. Actual due amount is: " + dueAmount);
        }

      
        List<Payment> payments = new ArrayList<>();

        Sale sale = new Sale(
                vehicle,
                customer,
                PaymentStaus.SUCCESS,
                LocalDate.now(),
                SaleStatus.COMPLETED,
                payments
        );

    
        Payment payment = new Payment(
                PaymentStaus.SUCCESS,
                reserveAmount,
                BigDecimal.ZERO,
                LocalDate.now(),
                vehicle,
                customer
        );

        payment.setSale(sale);

        payments.add(payment);

        sale.setPayment(payments);

      
        buyDao.createSaleTransaction(sale);

        
        reservation.setReserveStatus(ReservationStatus.COMPLETED);

        reserveDao.updateReservation(reservation);

       
        vehicle.setVehicleStatus(VehicalStatus.SOLD);

        vehicleDao.updateVehicle(vehicle);
    }
    @Override
    @Transactional(readOnly = true)
	public
    List<Sale> searchSales(Integer saleId, Integer customerId, Integer vehicleId)
{

        System.out.println("You have chosen to search sales");

        try {
            System.out.println("Enter sale ID (0 to skip):");
            int saleInput = saleId;

            System.out.println("Enter customer ID (0 to skip):");
            int customerInput = customerId;

            System.out.println("Enter vehicle ID (0 to skip):");
            int vehicleInput = vehicleId;

            if (saleInput < 0 || customerInput < 0 || vehicleInput < 0) {
                throw new Exception("IDs cannot be negative");
            }

           
            if (saleId == null && customerId == null && vehicleId == null) {
                throw new Exception("Enter at least one search field");
            }

            List<Sale> sales =
                    buyDao.searchSales(saleId, customerId, vehicleId);

            if (sales == null || sales.isEmpty()) {
                System.out.println("No matching sales found");
                return null;
            }

            System.out.println("\nMatching Sales Details:");

            return sales;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    private void displaySaleDetails(Sale sale) {

        System.out.println("\n================================");
        System.out.println("SALE DETAILS");
        System.out.println("================================");

        System.out.println("Sale ID       : " + sale.getId());
        System.out.println("Sale Date     : " + sale.getSaleDate());
        System.out.println("Sale Status   : " + sale.getSaleStatus());
        System.out.println("Payment Status: " + sale.getPaymentStatus());

        System.out.println("\nCUSTOMER DETAILS");
        System.out.println("Customer ID   : " + sale.getCustomerId().getId());
        System.out.println("Customer Name : " + sale.getCustomerId().getName());

        System.out.println("\nVEHICLE DETAILS");
        System.out.println("Vehicle ID    : " + sale.getVehicleId().getId());
        System.out.println("Brand         : " + sale.getVehicleId().getBrand());
        System.out.println("Model         : " + sale.getVehicleId().getModel());
        System.out.println("Price         : " + sale.getVehicleId().getPrice());

        System.out.println("\nPAYMENT DETAILS");

        List<Payment> payments = sale.getPayment();

        if (payments == null || payments.isEmpty()) {
            System.out.println("No payment records found");
        } else {

            for (Payment payment : payments) {

                System.out.println("----------------------------");
                System.out.println("Payment ID     : " + payment.getId());
                System.out.println("Payment Status : " + payment.getPaymentStatus());
                System.out.println("Amount Paid    : " + payment.getAmount());
                System.out.println("Due Amount     : " + payment.getDueAmount());
                System.out.println("Payment Date   : " + payment.getPaymnetDate());
            }
        }

        System.out.println("================================");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sale> getAllSales() {

        System.out.println("You have chosen to view all sales");

        try {
            List<Sale> sales = buyDao.getAllSales();

            if (sales == null || sales.isEmpty()) {
                System.out.println("No sales records found");
                return null;
            }

            return sales;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

   
    @Override
    @Transactional
    public void buyByDirect(
            int custId,
            int vehicleIdNumber,
            BigDecimal amount) {

        Customer customer = customerDao.getCustomerById(custId);

        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        Vehicle vehicle = vehicleDao.getVehicleById(vehicleIdNumber);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }

        if (vehicle.getVehicleStatus() != VehicalStatus.AVAILABLE) {
            throw new IllegalArgumentException(
                    "Vehicle is not available for direct purchase");
        }

        if (amount == null || vehicle.getPrice() == null) {
            throw new IllegalArgumentException("Invalid payment amount");
        }

      
        if (amount.compareTo(vehicle.getPrice()) != 0) {
            throw new IllegalArgumentException(
                    "Full vehicle price required: " + vehicle.getPrice());
        }

      
        List<Payment> payments = new ArrayList<>();

        Sale sale = new Sale(
                vehicle,
                customer,
                PaymentStaus.SUCCESS,
                LocalDate.now(),
                SaleStatus.COMPLETED,
                payments
        );

        
        Payment payment = new Payment(
                PaymentStaus.SUCCESS,
                amount,
                BigDecimal.ZERO,
                LocalDate.now(),
                vehicle,
                customer
        );

        payment.setSale(sale);

        payments.add(payment);

        sale.setPayment(payments);

       
        buyDao.createSaleTransaction(sale);

       
        vehicle.setVehicleStatus(VehicalStatus.SOLD);

        vehicleDao.updateVehicle(vehicle);
    }
    @Override
    public Map<String, Object> generateSalesReport() {

        Map<String, Object> report = buyDao.getSalesReport();

        System.out.println("\n======================================");
        System.out.println("             SALES REPORT");
        System.out.println("======================================");

        if (report == null || report.isEmpty()) {
            System.out.println("No sales information available.");
            return null;
        }

        System.out.println("Total Sales       : " + report.get("Total Sales"));
        System.out.println("Completed Sales   : " + report.get("Completed Sales"));
        System.out.println("Total Sales Value : ₹" + report.get("Total Sales Value"));

        System.out.println("======================================");
        return report;
    }
	@Override
	public Vehicle getVehicleById(int id) {

	    Vehicle vehicle=vehicleDao.getVehicleById(id);
	    return vehicle;

	}
}