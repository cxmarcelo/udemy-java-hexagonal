package com.mcb.hexagonal.application.core.usercase;

import com.mcb.hexagonal.application.core.domain.Customer;
import com.mcb.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mcb.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

	private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

	public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
		this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
	}

	//Pode criar exception personalizada
	@Override
	public Customer find(String id) {
		return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found."));
	}

}
