package com.mcb.hexagonal.adapters.out.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class AddressEntity {

	private String street;

	private String city;

	private String state;

}
