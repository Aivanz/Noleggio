package it.relatech.dao;

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
		delete(noleggio);
	}

}
