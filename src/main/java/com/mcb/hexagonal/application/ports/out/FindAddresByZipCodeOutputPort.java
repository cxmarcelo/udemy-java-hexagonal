package com.mcb.hexagonal.application.ports.out;

import com.mcb.hexagonal.application.core.domain.Address;

public interface FindAddresByZipCodeOutputPort {

	Address find(String zipCode);

}
