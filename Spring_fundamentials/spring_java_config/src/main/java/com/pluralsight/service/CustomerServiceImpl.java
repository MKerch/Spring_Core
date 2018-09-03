package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {


	private CustomerRepository customerRepository;

	public CustomerServiceImpl() {

	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using constructor injection");
		this.customerRepository = customerRepository;
	}
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using setter injection");
		this.customerRepository = customerRepository;
	}
}
