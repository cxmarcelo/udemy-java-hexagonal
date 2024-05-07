package com.mcb.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.mcb.hexagonal.application.core.usercase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

	@Bean
	FindCustomerByIdUseCase findCustomerByIdUseCase(
			FindCustomerByIdAdapter findCustomerByIdAdapter) {
		return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
	}

}
