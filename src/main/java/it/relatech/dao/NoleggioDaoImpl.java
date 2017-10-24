package it.relatech.dao;

import java.util.List;

import it.relatech.model.Noleggio;

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
