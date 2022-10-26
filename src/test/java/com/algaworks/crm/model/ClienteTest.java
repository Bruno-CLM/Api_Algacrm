package com.algaworks.crm.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClienteTest {

	@Mock
	Cliente cliente;
	
	@Test
	public void testModelCliente() {
		
		cliente.setId(new Long(2));
		cliente.setCpf("21321421321");
		cliente.setNome("Irineu");
		
		assertNotNull(cliente.getId());
		assertNotNull(cliente.getNome());
		assertNotNull(cliente.getCpf());
	}
	
}
