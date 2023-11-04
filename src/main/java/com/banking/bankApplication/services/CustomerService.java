package com.banking.bankApplication.services;

import java.util.List;

import com.banking.bankApplication.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomerDetails();

	public Customer addCustomer(Customer customer);

	public void deleteCustomerbyId(int cid);

	public Customer changeCustomerAddress(int cid, Customer customer);

	public Customer changeCustomerAddress(String address);

	public void updateCustomer(Customer customer);

	public void updateCustomerValues(int cid, Customer customer);

}
