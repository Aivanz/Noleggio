package it.relatech.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Cliente;
import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;

@Repository
@Transactional
public class NoleggioDaoImpl extends AbstractDao implements NoleggioDao {

	@Override
	public Noleggio saveNoleggio(Noleggio noleggio) {

		Cliente tempCliente = noleggio.getCliente();
		Veicolo tempVeicolo = noleggio.getVeicolo();

		noleggio.setCliente(
				(Cliente) getSession().createCriteria(Cliente.class).add(Restrictions.eq("nome", tempCliente.getNome()))
						.add(Restrictions.eq("cognome", tempCliente.getCognome())).uniqueResult());

		noleggio.setVeicolo((Veicolo) getSession().createCriteria(Veicolo.class)
				.add(Restrictions.eq("targa", tempVeicolo.getTarga())).uniqueResult());

		persist(noleggio);
		return noleggio;
	}

	@Override
	public Noleggio deleteNoleggio(Noleggio noleggio) {
		List<Noleggio> listNoleggi = getSession().createCriteria(Noleggio.class).list();
		Noleggio temp = null;
		for (Noleggio noleggio2 : listNoleggi) {
			if (noleggio.equals(noleggio2))
				temp = noleggio2;
		}

		if (temp == null)
			return temp;
		else {
			delete(temp);
			return temp;
		}

	}

	@Override
	public List<Noleggio> getListNoleggio() {
		return (List<Noleggio>) getSession().createQuery("SELECT n FROM Noleggio n").list();
	}

	@Override
	public List<Veicolo> getListDisp() {
		List<Veicolo> listDisp = getSession().createQuery("SELECT v FROM Veicolo v WHERE v.listNoleggio IS EMPTY ")
				.list();
		return listDisp;

	}

}
