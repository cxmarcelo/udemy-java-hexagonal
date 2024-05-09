package com.mcb.hexagonal.adapters.out.client.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.hexagonal.adapters.out.client.response.AddressResponse;
import com.mcb.hexagonal.application.core.domain.Address;

@Component
public class AddressResponseMapper {

	public Address toAddress(AddressResponse addressResponse) {
		Address address = new Address();
		BeanUtils.copyProperties(addressResponse, address);
		return address;
	}

}
