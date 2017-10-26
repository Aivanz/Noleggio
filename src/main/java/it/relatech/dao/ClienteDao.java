package it.relatech.dao;

import java.util.List;

import it.relatech.model.Cliente;

public interface ClienteDao {
	
	Cliente saveCliente (Cliente cliente);
	
	Cliente updateCliente (Cliente cliente);
	
	Cliente deleteCliente(Cliente cliente);
	
	List<Cliente> getListClienti();
	
}
