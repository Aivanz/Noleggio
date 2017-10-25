package it.relatech.dao;

import it.relatech.model.Noleggio;

public interface NoleggioDao {

	Noleggio saveNoleggio(Noleggio noleggio);

	void deleteNoleggio(Noleggio noleggio);

}
