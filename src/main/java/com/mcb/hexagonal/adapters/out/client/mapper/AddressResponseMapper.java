package com.mcb.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import com.mcb.hexagonal.adapters.out.client.response.AddressResponse;
import com.mcb.hexagonal.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
	
	Address toAddress(AddressResponse addressResponse);

}
