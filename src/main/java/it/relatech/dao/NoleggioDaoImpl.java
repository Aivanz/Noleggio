package it.relatech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Noleggio;

@Repository
@Transactional
public class NoleggioDaoImpl extends AbstractDao implements NoleggioDao {

	@Override
	public Noleggio saveNoleggio(Noleggio noleggio) {
		persist(noleggio);
		return noleggio;
	}

	@Override
	public void deleteNoleggio(Noleggio noleggio) {
		List<Noleggio> listNoleggi = getSession().createCriteria(Noleggio.class).list();
		Noleggio temp = null;
		for (Noleggio noleggio2 : listNoleggi) {
			if (noleggio.equals(noleggio2))
				temp = noleggio2;
		}

		delete(temp);
	}

}
