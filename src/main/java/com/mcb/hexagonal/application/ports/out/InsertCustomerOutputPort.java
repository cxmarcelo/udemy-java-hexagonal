package com.mcb.hexagonal.application.ports.out;

import com.mcb.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

	void insert(Customer customer);

}
