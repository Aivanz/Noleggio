package it.relatech.dao;
import java.util.List;


import it.relatech.model.Veicolo;

public interface VeicoloDao {
	
Veicolo saveVeicolo(Veicolo v);

Veicolo updateVeicolo(Veicolo v);


void deleteVeicoloById(int id);

List<Veicolo> getListVeicoli();

Veicolo getVeicoloById(int id);

Veicolo noleggia (Veicolo v);

Veicolo restituisci (Veicolo v);


}
