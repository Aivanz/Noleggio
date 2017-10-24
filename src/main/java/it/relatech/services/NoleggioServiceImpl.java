package it.relatech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.dao.NoleggioDao;
import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;

@Service
public class NoleggioServiceImpl implements NoleggioService {

	@Autowired
	private NoleggioDao noleggioDao;

	@Override
	public Noleggio saveNoleggio(Noleggio noleggio) {
		return noleggioDao.saveNoleggio(noleggio);
	}

	@Override
	public void deleteNoleggio(Noleggio noleggio) {
		noleggioDao.deleteNoleggio(noleggio);
	}

	@Override
	public List<Veicolo> getListDisp() {

		VeicoloService veicoloService = new VeicoloServiceImpl();
		List<Veicolo> listDisp = new ArrayList<>();
		List<Veicolo> listVeicolo = veicoloService.getListVeicolo();

		for (Veicolo veicolo : listVeicolo) {
			if (veicolo.getListNoleggio().isEmpty()) {
				listDisp.add(veicolo);
			}
		}

		return listDisp;

	}

}
