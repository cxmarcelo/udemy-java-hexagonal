package com.mcb.hexagonal.application.ports.out;

public interface SendCpfForValidationOutputPort {

	void send(String cpf);

}
