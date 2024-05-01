package com.mcb.hexagonal.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.mcb.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mcb.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

	CustomerEntity toCustomerEntity(Customer customer);
	
}
