package it.relatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.model.Veicolo;

@Service
public class VeicoloServiceImpl implements VeicoloService  {

	@Autowired
	private VeicoloDao veicoloDao;
	
	@Override
	public Veicolo saveVeicolo(Veicolo veicolo) {
		return veicoloDao.saveVeicolo(veicolo);
	}
	
	@Override
	public Veicolo updateVeicolo(Veicolo veicolo) {
		return veicoloDao.updateVeicolo(veicolo);
	}
	
	@Override
	public void deleteVeicoloById(int id) {
		veicoloDao.deleteVeicoloById(id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veicolo> getListVeicoli() {
		return veicoloDao.getListVeicoli;
	}
	
	@Override
	public Veicolo getVeicoloById(int id) {
		return veicoloDao.getVeicoloById(id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veicolo> getListByCategoria() {
		return veicoloDao.getListByCategoria();
	}
	
	public Veicolo noleggia(Veicolo veicolo) {
		return veicoloDao.noleggia();
	}
	
	@Override
	public Veicolo restituisci(Veicolo veicolo) {
		return veicoloDao.restituisci;
	}

}
