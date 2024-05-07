package com.mcb.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mcb.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mcb.hexagonal.application.core.usercase.FindCustomerByIdUseCase;
import com.mcb.hexagonal.application.core.usercase.UpdateCustomerUseCase;

@Configuration
public class DeleteCustomerByIdConfig {

	@Bean
	UpdateCustomerUseCase findCustomerByIdUseCase(
			FindCustomerByIdUseCase findCustomerByIdUseCase,
			FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
			UpdateCustomerAdapter updateCustomerAdapter) {
		return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
	}

}
