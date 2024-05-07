package com.mcb.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.mcb.hexagonal.application.core.usercase.DeleteCustomerByIdUseCase;
import com.mcb.hexagonal.application.core.usercase.FindCustomerByIdUseCase;

@Configuration
public class UpdateCustomerConfig {

	@Bean
	DeleteCustomerByIdUseCase findCustomerByIdUseCase(
			FindCustomerByIdUseCase findCustomerByIdUseCase,
			DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
		return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
	}

}
