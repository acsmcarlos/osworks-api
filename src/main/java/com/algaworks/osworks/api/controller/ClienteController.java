package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping     // BUSCAR TODOSO OS CLIENTES
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);

		if (cliente.isPresent()) { //se cliente existe
			return ResponseEntity.ok(cliente.get()); //retorna o cliente (status 200 OK)
		}
		
		return ResponseEntity.notFound().build(); //se nao houver cliente retorna status 404
	}
	//INSERIR UM RECURSO
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)    // retornar status 201 created
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {  
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId,  //se o id não existe
			@RequestBody Cliente cliente) {
		
		if (!clienteRepository.existsById(clienteId)) {   //se nao existe
			return ResponseEntity.notFound().build();  //returna 404
		}
		//se existir
		cliente.setId(clienteId); //para nao criar outro cliente
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {

	if (!clienteRepository.existsById(clienteId)) {   //se nao existe
		return ResponseEntity.notFound().build();  //returna 404
	}
	
	clienteRepository.deleteById(clienteId);
	
	return ResponseEntity.noContent().build();
	}
}
