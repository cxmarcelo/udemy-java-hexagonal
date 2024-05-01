package com.mcb.hexagonal.application.core.usercase;

import com.mcb.hexagonal.application.core.domain.Customer;
import com.mcb.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mcb.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import com.mcb.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

	private final FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort;

	private final InsertCustomerOutputPort insertCustomerOutputPort;

	public InsertCustomerUseCase(
			FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort, 
			InsertCustomerOutputPort insertCustomerOutputPort
			) {
		this.findAddresByZipCodeOutputPort = findAddresByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
	}

	@Override
	public void insert(Customer customer, String zipCode) {
		var address = findAddresByZipCodeOutputPort.find(zipCode);
		customer.setAddress(address);
		
		insertCustomerOutputPort.insert(customer);
	}

}
