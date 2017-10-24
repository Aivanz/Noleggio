package it.relatech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.dao.NoleggioDao;
import it.relatech.model.Noleggio;

@Service
public class NoleggioServiceImpl implements NoleggioService {

	@Autowired
	private NoleggioDao noleggioDao;
	
	@Override
	public Noleggio saveNoleggio(Noleggio noleggio) {
		return noleggioDao.saveNoleggio(noleggio);
	}

	@Override
	public Noleggio deleteNoleggio(Noleggio noleggio) {
		noleggioDao.deleteNoleggio(noleggio);
	}

}
