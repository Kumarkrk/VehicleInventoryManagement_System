
package com.te.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.te.model.Customer;
import com.te.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	public CustomerController() {
	    System.out.println("CustomerControll	er Bean Created");
	}
    @Autowired
    private CustomerService customerService;

    
    @GetMapping("/all")
    public String getCustomers(Model model) {

        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "customer-list";
    }

    
    @GetMapping("/addall")
    public String showAddCustomerForm() {
    	System.out.println("hi this is from add all");

        return "add-customer";
    }

   
    @PostMapping("/add")
    public String addCustomer(
            Customer customer,
            Model model,
            RedirectAttributes redirectAttributes) {

        try {
            customerService.addCustomer(customer);

            redirectAttributes.addFlashAttribute(
                    "message", "Customer added successfully");

            return "redirect:/customers/all";

        } catch (Exception e) {

            model.addAttribute("errorMessage", e.getMessage());

            return "add-customer";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(
            @RequestParam("id") int id,
            RedirectAttributes redirectAttributes) {

        customerService.deleteCustomer(id);

        redirectAttributes.addFlashAttribute(
                "message", "Customer deleted successfully");

        return "redirect:/customers/all";
    }

    // Search customer
    @PostMapping("/search")
    public String searchCustomer(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("mobileNo") String mobileNo,
            Model model) {
    	  try {
    	        List<Customer> customers =
    	                customerService.searchCustomer(name, address, mobileNo);

    	        model.addAttribute("customers", customers);
    	        return "customer-list";

    	    } catch (IllegalArgumentException e) {
    	        model.addAttribute("errorMessage", e.getMessage());
    	        return "search-customer";
    	    }
        
    }

  
    @GetMapping("/edit")
    public String showUpdateForm(
            @RequestParam("id") int id, Model model) {

        // Requires a getCustomerById(int id) method in CustomerService
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);

        return "update-customer";
    }

   
    @PostMapping("/update")
    public String updateCustomer(
            Customer customer,
            Model model) {


    	try {
            customerService.updateCustomer(customer);

            model.addAttribute("message",
                    "Customer updated successfully!");

            model.addAttribute("customers",
                    customerService.getCustomers());

            return "customer-list";

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            model.addAttribute("customer", customer);

            return "update-customer";
        }
       
    }
}
