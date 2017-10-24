package it.relatech.services;

import it.relatech.model.Noleggio;

public interface NoleggioService {

	Noleggio saveNoleggio(Noleggio noleggio);
	
	Noleggio deleteNoleggio(Noleggio noleggio);

}
