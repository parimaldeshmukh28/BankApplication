package com.banking.bankApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bankApplication.model.Customer;
import com.banking.bankApplication.model.CustomerPatchRequest;
import com.banking.bankApplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomerDetails() {
		List<Customer> clist = customerRepository.findAll();
		System.out.println("In Service layer :" + clist);
		return clist;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerbyId(int cid) {
		customerRepository.deleteById(cid);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findById(customer.getCid());
		if (existingCustomer.isPresent()) {
			customerRepository.save(customer);
		} else {
			System.out.println("Customer doesn't exist!!!");
		}

	}

	@Override
	public void updateCustomerValues(CustomerPatchRequest customer) {
		Optional<Customer> existingCustomer = customerRepository.findById(customer.getCid());
		if (existingCustomer.isPresent()) {
			Customer existingCustomerObj = existingCustomer.get();
			BeanUtils.copyProperties(customer, existingCustomerObj);
			customerRepository.save(existingCustomerObj);
		} else {
			System.out.println("Customer doesn't exist!!!");
		}
	}
}
