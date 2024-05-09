package com.mcb.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.mcb.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mcb.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mcb.hexagonal.application.core.usercase.FindCustomerByIdUseCase;
import com.mcb.hexagonal.application.core.usercase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerConfig {

	@Bean
	@DependsOn({"findCustomerByIdUseCase", "findAddressByZipCodeAdapter", "updateCustomerAdapter"})
	UpdateCustomerUseCase updateCustomerUseCase(
			FindCustomerByIdUseCase findCustomerByIdUseCase,
			FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
			UpdateCustomerAdapter updateCustomerAdapter) {
		return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
	}

}
