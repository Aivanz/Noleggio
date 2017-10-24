package it.relatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService  {

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente saveCliente(it.relatech.model.Cliente cliente) {
		return clienteDao.saveCliente(cliente);
	}

	@Override
	public Cliente updateCliente(it.relatech.model.Cliente cliente) {
		return clienteDao.updateCliente(cliente);
	}

	@Override
	public void deleteClienteById(int id) {
		clienteDao.deleteClienteById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getListClienti() {
		return clienteDao.getListClienti();
	}
	
}
