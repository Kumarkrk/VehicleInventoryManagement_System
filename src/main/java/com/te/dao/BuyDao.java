package com.te.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.te.model.Sale;
@Repository
public interface BuyDao {
     void createSaleTransaction(Sale sale);
     List<Sale> getAllSales();
     Map<String, Object> getSalesReport();
     List<Sale> searchSales(Integer saleId, Integer customerId, Integer vehicleId);
}
