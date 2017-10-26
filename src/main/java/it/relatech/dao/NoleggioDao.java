package it.relatech.dao;

import java.util.List;

import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;

public interface NoleggioDao {

	Noleggio saveNoleggio(Noleggio noleggio);

	Noleggio deleteNoleggio(Noleggio noleggio);

	List<Noleggio> getListNoleggio();

	List<Veicolo> getListDisp();

}
