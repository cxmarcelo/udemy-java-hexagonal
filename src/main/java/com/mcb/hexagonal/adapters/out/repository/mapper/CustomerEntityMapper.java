package com.mcb.hexagonal.adapters.out.repository.mapper;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.mcb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mcb.hexagonal.application.core.domain.Address;
import com.mcb.hexagonal.application.core.domain.Customer;

@Component
public class CustomerEntityMapper {

    public CustomerEntity toCustomerEntity(Customer customer) {
    	CustomerEntity customerEntity = new CustomerEntity();
    	BeanUtils.copyProperties(customer, customerEntity);
    	
    	AddressEntity addressEntity = new AddressEntity();
      	BeanUtils.copyProperties(customer.getAddress(), addressEntity);
        
      	customerEntity.setAddress(addressEntity);
    	return customerEntity;
    }

    public Customer toCustomer(CustomerEntity customerEntity) {
    	Customer customer = new Customer();
    	BeanUtils.copyProperties(customerEntity, customer);
    	
    	Address address = new Address();
      	BeanUtils.copyProperties(customerEntity.getAddress(), address);
        
      	customer.setAddress(address);
    	return customer;
    }

}