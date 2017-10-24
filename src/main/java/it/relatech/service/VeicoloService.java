package it.relatech.service;

import java.util.List;

import it.relatech.model.Veicolo;

public interface VeicoloService {

	Veicolo saveVeicolo(Veicolo veicolo);
	
	Veicolo updateVeicolo(Veicolo veicolo);
	
	void deleteVeicoloById(int id);
	
	List<Veicolo> getListVeicoli();
	
	Veicolo getVeicoloById(int id);
	
	List<Veicolo> getListByCategoria();
	
	Veicolo noleggia(Veicolo veicolo);
	
	Veicolo restituisci(Veicolo veicolo);
}
