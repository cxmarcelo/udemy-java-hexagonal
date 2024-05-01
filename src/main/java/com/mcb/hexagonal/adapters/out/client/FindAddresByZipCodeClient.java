package com.mcb.hexagonal.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mcb.hexagonal.adapters.out.client.response.AddressResponse;

@FeignClient(
		name = "FindAddresByZipCodeClient",
		url = "${marcelo.client.address.url}"
		)
public interface FindAddresByZipCodeClient {

	@GetMapping("/{zipCoe}")
	AddressResponse find(@PathVariable("zipCode") String zipCode);

}
