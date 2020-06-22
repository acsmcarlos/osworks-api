package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Tonin");
		cliente1.setTelefone("8888-8888");
		cliente1.setEmail("email");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Carlin");
		cliente2.setTelefone("1111-1111");
		cliente2.setEmail("email2");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
