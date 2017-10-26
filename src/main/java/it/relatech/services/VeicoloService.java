package it.relatech.services;

import java.util.List;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

public interface VeicoloService {

	Veicolo saveVeicolo(Veicolo veicolo);

	Veicolo updateVeicolo(Veicolo veicolo);

	Veicolo deleteVeicolo(Veicolo veicolo);

	List<Veicolo> getListVeicolo();

	Veicolo getVeicoloById(int id);

	List<Veicolo> getListByCategoria(Categoria categoria);
}
