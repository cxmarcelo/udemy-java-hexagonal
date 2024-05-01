package com.mcb.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.out.client.FindAddresByZipCodeClient;
import com.mcb.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.mcb.hexagonal.application.core.domain.Address;
import com.mcb.hexagonal.application.ports.out.FindAddresByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements FindAddresByZipCodeOutputPort {

	@Autowired
	private FindAddresByZipCodeClient findAddresByZipCodeClient;

	@Autowired
	private AddressResponseMapper addressResponseMapper;

	@Override
	public Address find(String zipCode) {
		var addressResponse = findAddresByZipCodeClient.find(zipCode);
		return addressResponseMapper.toAddress(addressResponse);
	}


}
