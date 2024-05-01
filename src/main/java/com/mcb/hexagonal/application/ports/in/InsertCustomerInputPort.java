package com.mcb.hexagonal.application.ports.in;

import com.mcb.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
	
	void insert(Customer customer, String zipCode);

}
