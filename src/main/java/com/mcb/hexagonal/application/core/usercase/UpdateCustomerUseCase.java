package com.mcb.hexagonal.application.core.usercase;

import com.mcb.hexagonal.application.core.domain.Customer;
import com.mcb.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mcb.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.mcb.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import com.mcb.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

	private final FindCustomerByIdInputPort findCustomerByIdInputPort;

	private final FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort;

	private final UpdateCustomerOutputPort updateCustomerOutputPort;


	public UpdateCustomerUseCase(
			FindCustomerByIdInputPort findCustomerByIdInputPort, 
			FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort,
			UpdateCustomerOutputPort updateCustomerOutputPort) {
		this.findCustomerByIdInputPort = findCustomerByIdInputPort;
		this.findAddresByZipCodeOutputPort= findAddresByZipCodeOutputPort;
		this.updateCustomerOutputPort = updateCustomerOutputPort;
	}


	@Override
	public void update(Customer customer, String zipCode) {
		findCustomerByIdInputPort.find(customer.getId());
		var address = findAddresByZipCodeOutputPort.find(zipCode);
		customer.setAddress(address);
		updateCustomerOutputPort.update(customer);
	}

}
