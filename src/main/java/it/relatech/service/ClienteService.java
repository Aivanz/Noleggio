package it.relatech.service;

import java.util.List;

import it.relatech.model.Cliente;

public interface ClienteService {

	Cliente saveCliente(Cliente cliente);
	
	Cliente updateCliente(Cliente cliente);
	
	void deleteClienteById(int id);
	
	List<Cliente> getListClienti();
		
}
