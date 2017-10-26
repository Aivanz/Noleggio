package it.relatech.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Cliente;
import it.relatech.model.Veicolo;

@Repository
@Transactional
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
	public Cliente deleteCliente(Cliente cliente) {
		List<Cliente> listClienti = getListClienti();
		Cliente temp = null;
		for (Cliente cliente2 : listClienti) {
			if (cliente.equals(cliente2))
				temp = cliente2;
		}

		if (temp == null)
			return temp;
		else {
			delete(temp);
			return temp;
		}
	}

	@Override
	public List<Cliente> getListClienti() {
		return (List<Cliente>) getSession().createCriteria(Cliente.class).list();
	}

}
