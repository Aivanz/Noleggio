package it.relatech.services;

import java.util.List;

import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;

public interface NoleggioService {

	Noleggio saveNoleggio(Noleggio noleggio);

	Noleggio deleteNoleggio(Noleggio noleggio);

	List<Veicolo> getListDisp();

	List<Noleggio> getListNoleggio();
}
