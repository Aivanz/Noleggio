package it.relatech.dao;
import java.util.List;


import it.relatech.model.Veicolo;

public interface VeicoloDao {
	
Veicolo saveVeicolo(Veicolo v);

Veicolo updateVeicolo(Veicolo v);


Veicolo deleteVeicolo(Veicolo v);

List<Veicolo> getListVeicolo();

Veicolo getVeicoloById(int id);

Veicolo noleggia (Veicolo v);

Veicolo restituisci (Veicolo v);


}
