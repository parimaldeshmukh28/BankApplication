package com.banking.bankApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bankApplication.model.Customer;
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
	public Customer changeCustomerAddress(int cid, Customer customer) {
		Customer existingCustomer = customerRepository.findById(cid).orElse(null);
		if (existingCustomer != null) {
			if (existingCustomer.getAddress() != null) {
				existingCustomer.setAddress(customer.getAddress());
			}
			return customerRepository.save(existingCustomer);
		}
		return null;
	}

	@Override
	public Customer changeCustomerAddress(String address) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findCustomerByAddres(address);
		if (customer != null) {
			customer.setAddress(address);
		}
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findById(customer.getCid());
		if(existingCustomer.isPresent()) {
			customerRepository.save(customer);
		}
		
	}

	@Override
	public void updateCustomerValues(int cid, Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findById(cid);
		if(existingCustomer.isPresent()) {
			Customer existingCustomerObj = existingCustomer.get();
			BeanUtils.copyProperties(existingCustomer, customer);
			customerRepository.save(existingCustomerObj);
		}
	}

}
