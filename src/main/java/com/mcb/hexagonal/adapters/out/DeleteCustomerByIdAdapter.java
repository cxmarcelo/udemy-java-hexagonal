package com.mcb.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.out.repository.CustomerRepository;
import com.mcb.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void delete(String id) {
		customerRepository.deleteById(id);
	}

}
