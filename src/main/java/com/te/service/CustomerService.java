package com.te.service;

import java.util.List;

import com.te.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	void deleteCustomer(int id);
    void updateCustomer(Customer customer) throws Exception;
    List<Customer> getCustomers();
    List<Customer> searchCustomer(String name, String address, String mobileNo);
	Customer getCustomerById(int id);

}
