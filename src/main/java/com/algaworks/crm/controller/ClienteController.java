package com.algaworks.crm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping()
	public Cliente listarClientes(@RequestParam String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String cadastrarCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return "Cliente cadastrado com sucesso!";
	}
	
	@DeleteMapping("/deletar")
	@ResponseStatus(code = HttpStatus.OK)
	public String deletarCliente(@RequestParam String cpf) {
		clienteRepository.deleteByCpf(cpf);
		return "Cliente deletado com sucesso!";
	}
	
}
