package it.relatech.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import it.relatech.model.Cliente;

public class ClienteDaoImpl extends AbstractDao implements ClienteDao {

	@Override
	public Cliente saveCliente(Cliente cliente) {
		persist(cliente);
		return cliente;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		update(cliente);
		return cliente;
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		delete(cliente);
	}

	@Override
	public List<Cliente> getListClienti() {
		return (List<Cliente>)getSession().createCriteria(Cliente.class).list();
	}

}
