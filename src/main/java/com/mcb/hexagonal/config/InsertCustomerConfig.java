package com.mcb.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mcb.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mcb.hexagonal.application.core.usercase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {

	@Bean
	InsertCustomerUseCase insertCustomerUseCase(
			FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
			InsertCustomerAdapter insertCustomerAdapter) {
		return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
	}

}
