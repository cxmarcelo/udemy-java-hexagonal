package com.mcb.hexagonal.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.out.repository.CustomerRepository;
import com.mcb.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mcb.hexagonal.application.core.domain.Customer;
import com.mcb.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

@Component("findCustomerByIdAdapter")
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerEntityMapper customerEntityMapper;
	
	@Override
	public Optional<Customer> find(String id) {
		var customerEntity = customerRepository.findById(id);
		return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
	}

}
