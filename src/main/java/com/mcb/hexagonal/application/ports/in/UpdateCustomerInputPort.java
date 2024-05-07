package com.mcb.hexagonal.application.ports.in;

import com.mcb.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

	void update(Customer customer, String zipCode);

}
