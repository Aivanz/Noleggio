package it.relatech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.dao.VeicoloDao;
import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

@Service
public class VeicoloServiceImpl implements VeicoloService {

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
	public void deleteVeicolo(Veicolo veicolo) {
		veicoloDao.deleteVeicolo(veicolo);
	}

	@Override
	public List<Veicolo> getListVeicolo() {
		return veicoloDao.getListVeicolo();
	}

	@Override
	public Veicolo getVeicoloById(int id) {
		return veicoloDao.getVeicoloById(id);
	}

	@Override
	public List<Veicolo> getListByCategoria(Categoria categoria) {
		return veicoloDao.getListByCategoria(categoria);
	}

}
