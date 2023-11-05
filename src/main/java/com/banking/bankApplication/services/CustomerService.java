package com.banking.bankApplication.services;

import java.util.List;

import com.banking.bankApplication.model.Customer;
import com.banking.bankApplication.model.CustomerPatchRequest;

public interface CustomerService {

	public List<Customer> getCustomerDetails();

	public Customer addCustomer(Customer customer);

	public void deleteCustomerbyId(int cid);

	public void updateCustomer(Customer customer);

	public void updateCustomerValues(CustomerPatchRequest customer);
}
