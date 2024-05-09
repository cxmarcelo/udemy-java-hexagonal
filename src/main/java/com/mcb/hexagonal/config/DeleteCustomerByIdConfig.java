package com.mcb.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.mcb.hexagonal.application.core.usercase.DeleteCustomerByIdUseCase;
import com.mcb.hexagonal.application.core.usercase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdConfig {

	@Bean
	DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
			FindCustomerByIdUseCase findCustomerByIdUseCase,
			DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
		return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
	}

}
