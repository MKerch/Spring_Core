package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    //@Autowired
	private CustomerRepository customerRepository;

	@Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("It is the constructor injection works");

        this.customerRepository = customerRepository;
    }

    //@Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("It is the setter injection works");
        this.customerRepository = customerRepository;
    }

    @Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
