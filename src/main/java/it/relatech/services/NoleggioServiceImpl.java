package it.relatech.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
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

		// NON FUNZIONA CAZZO

		// Se metto getListNoleggio().isEmpty() mi dà NullPointerException

		// Se metto size() == 0 mi dà NullPointerException

		// Se metto getListNoleggio() == null non li vede proprio e quindi TUTTI i
		// veicoli apparentemente hanno la listNoleggio piena e quindi non li carica in
		// listDisp

		List<Veicolo> listVeicolo = veicoloService.getListVeicolo();

		listVeicolo.forEach(System.out::println);

		List<Veicolo> listDisp = new ArrayList<>();

		for (Veicolo veicolo : listVeicolo) {
			if (veicolo.getListNoleggio() == null) {
				System.out.println(veicolo);
				listDisp.add(veicolo);
			} else
				System.out.println(veicolo + "non è vuoto");
		}

		System.out.println("listDisp: \n");
		listDisp.forEach(System.out::println);

		return listDisp;

	}

}
