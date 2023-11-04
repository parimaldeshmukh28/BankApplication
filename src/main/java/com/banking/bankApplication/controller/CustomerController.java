package com.banking.bankApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankApplication.model.Customer;
import com.banking.bankApplication.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomerDetails() {
		List<Customer> clist = customerService.getCustomerDetails();
		System.out.println("In Controller layer :" + clist);
		return clist;
	}

	@PostMapping
	public String addCustomer(@RequestBody Customer customer) {
		System.out.println("check customer :" + customer);
		customerService.addCustomer(customer);
		return "Customer Added Successfully";
	}

	@DeleteMapping(value = "/{cid}")
	public String deleteCustomerById(@PathVariable("cid") int cid) {
		customerService.deleteCustomerbyId(cid);
		return "deleted Successfully";
	}

	@PutMapping(value = "")
	public String updateCustomerObject(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return "customer changed";
	}
	
	@PatchMapping(value="/{cid}")
	public String  updateCustomer(@PathVariable("cid") int cid, @RequestBody Customer customer){
		customerService.updateCustomerValues(cid, customer);
		return "customer updated";
	}

}
