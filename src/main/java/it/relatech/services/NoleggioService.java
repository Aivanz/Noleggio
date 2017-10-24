package it.relatech.services;

import java.util.List;

import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;

public interface NoleggioService {

	Noleggio saveNoleggio(Noleggio noleggio);

	void deleteNoleggio(Noleggio noleggio);

	List<Veicolo> getListDisp();
}
