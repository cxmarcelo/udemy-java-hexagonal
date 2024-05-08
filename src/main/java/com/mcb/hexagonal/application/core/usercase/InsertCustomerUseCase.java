package com.mcb.hexagonal.application.core.usercase;

import com.mcb.hexagonal.application.core.domain.Customer;
import com.mcb.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mcb.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;
import com.mcb.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.mcb.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

	private final FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort;

	private final InsertCustomerOutputPort insertCustomerOutputPort;
	
	private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

	public InsertCustomerUseCase(
			FindAddresByZipCodeOutputPort findAddresByZipCodeOutputPort, 
			InsertCustomerOutputPort insertCustomerOutputPort,
			SendCpfForValidationOutputPort sendCpfForValidationOutputPort
			) {
		this.findAddresByZipCodeOutputPort = findAddresByZipCodeOutputPort;
		this.insertCustomerOutputPort = insertCustomerOutputPort;
		this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
	}

	@Override
	public void insert(Customer customer, String zipCode) {
		var address = findAddresByZipCodeOutputPort.find(zipCode);
		customer.setAddress(address);
		insertCustomerOutputPort.insert(customer);
		sendCpfForValidationOutputPort.send(customer.getCpf());
	}

}
