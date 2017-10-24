package it.relatech.dao;

import java.util.List;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

public interface VeicoloDao {

	Veicolo saveVeicolo(Veicolo v);

	Veicolo updateVeicolo(Veicolo v);

	void deleteVeicolo(Veicolo veicolo);

	List<Veicolo> getListVeicoli();

	Veicolo getVeicoloById(int id);

	List<Veicolo> getListByCategoria(Categoria categoria);

}
