package com.mcb.hexagonal.adapters.in.controller.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mcb.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mcb.hexagonal.application.core.domain.Customer;

@Component
public class CustomerMapper {
	
	public Customer toCustomer(CustomerRequest customerRequest) {
    	Customer customer = new Customer();
    	BeanUtils.copyProperties(customerRequest, customer);
    	return customer;
	}

	public CustomerResponse toCustomerResponse(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
    	BeanUtils.copyProperties(customer, customerResponse);
    	return customerResponse;
	}
	
	
}
