package com.mcb.hexagonal.adapters.in.consumer.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.mcb.hexagonal.application.core.domain.Customer;

@Component
public class CustomerMessageMapper {

    public Customer toCustomer(CustomerMessage customerMessage) {
    	Customer customer = new Customer();
    	BeanUtils.copyProperties(customerMessage, customer);
    	return customer;
    }
	
}
