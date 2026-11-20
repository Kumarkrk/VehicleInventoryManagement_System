package com.te.dao;

import java.util.List;

import com.te.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);
	void deleteCustomer(int id);
	void updateCustomer(Customer customer);
	List<Customer> getAllCustomers();
	List<Customer> searchCustomer(String name, String address, String mobileNo);
	Customer getCustomerById(int id);
	

}
