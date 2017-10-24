package it.relatech.services;

import java.util.List;

import it.relatech.model.Cliente;

public interface ClienteService {

	Cliente saveCliente(Cliente cliente);

	Cliente updateCliente(Cliente cliente);

	void deleteCliente(Cliente cliente);

	List<Cliente> getListCliente();
}
