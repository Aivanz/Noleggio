package it.relatech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.dao.ClienteDao;
import it.relatech.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteDao.saveCliente(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clienteDao.updateCliente(cliente);
	}

	@Override
	public Cliente deleteCliente(Cliente cliente) {
		clienteDao.deleteCliente(cliente);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getListCliente() {
		return clienteDao.getListCliente();
	}
	
	
}
