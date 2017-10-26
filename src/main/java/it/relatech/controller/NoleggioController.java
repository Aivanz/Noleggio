package it.relatech.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.relatech.model.Cliente;
import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;
import it.relatech.services.NoleggioService;

@RestController
@RequestMapping("/noleggio")
public class NoleggioController {

	private final Logger logger = Logger.getLogger(NoleggioController.class.getName());

	@Autowired
	private NoleggioService noleggioService;

	@GetMapping("/getModel")
	public Noleggio getNoleggioModel() {
		return new Noleggio();
	}

	@GetMapping("/getList")
	public ResponseEntity<List<Noleggio>> getListNoleggio() {
		try {
			List<Noleggio> listNoleggio = noleggioService.getListNoleggio();
			if (listNoleggio.isEmpty()) {
				logger.info("Lista noleggi vuota");
				return new ResponseEntity<List<Noleggio>>(HttpStatus.OK);
			}
			logger.info("Lista noleggi: ");
			for (Noleggio noleggio : listNoleggio) {
				logger.info(noleggio.toString());
			}
			return new ResponseEntity<List<Noleggio>>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<List<Noleggio>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Noleggio> saveNoleggio(@RequestBody Noleggio noleggio) {
		try {
			Noleggio savedNoleggio = noleggioService.saveNoleggio(noleggio);
			if (noleggio.getCliente() == null || noleggio.getVeicolo() == null) {
				if (noleggio.getCliente() == null) {
					logger.info("Noleggio inserito senza Cliente\n" + noleggio);
				} else if (noleggio.getVeicolo() == null) {
					logger.info("Noleggio inserito senza Veicolo\n" + noleggio);
				}
			} else {
				logger.info("Noleggio creato: \n" + noleggio);
			}
			return new ResponseEntity<Noleggio>(savedNoleggio, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Noleggio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/restituisci")
	public ResponseEntity<Noleggio> restituisci(@RequestBody Noleggio noleggio) {
		try {
			Noleggio tempNoleggio = noleggioService.deleteNoleggio(noleggio);
			if (tempNoleggio == null)
				logger.info("Noleggio da restituire non trovato\n");
			else
				logger.info("Noleggio restituito: \n" + tempNoleggio);
			return new ResponseEntity<Noleggio>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Noleggio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getListDisp")
	public ResponseEntity<List<Veicolo>> getListDisp() {
		try {
			List<Veicolo> listVeicolo = noleggioService.getListDisp();
			if (listVeicolo.isEmpty()) {
				logger.info("Lista veicoli disponibili vuota");
				return new ResponseEntity<List<Veicolo>>(HttpStatus.OK);
			}
			logger.info("Lista veicoli disponibili: ");
			for (Veicolo veicolo : listVeicolo) {
				logger.info(veicolo.toString());
			}
			return new ResponseEntity<List<Veicolo>>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
