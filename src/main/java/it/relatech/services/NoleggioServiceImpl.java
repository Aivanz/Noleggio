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

	@Autowired
	private VeicoloService veicoloService;

	@Autowired
	private ClienteService clienteService;

	@Override
	public Noleggio saveNoleggio(Noleggio noleggio) {
		return noleggioDao.saveNoleggio(noleggio);
	}

	@Override
	public Noleggio deleteNoleggio(Noleggio noleggio) {
		return noleggioDao.deleteNoleggio(noleggio);
	}

	@Override
	public List<Veicolo> getListDisp() {
		return noleggioDao.getListDisp();
	}

	@Override
	public List<Noleggio> getListNoleggio() {
		return noleggioDao.getListNoleggio();
	}

}
