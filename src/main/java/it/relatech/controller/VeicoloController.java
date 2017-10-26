package it.relatech.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;
import it.relatech.services.VeicoloService;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {

	private final Logger logger = Logger.getLogger(VeicoloController.class.getName());

	@Autowired
	private VeicoloService veicoloService;

	@GetMapping("/getModel")
	public Veicolo getVeicoloModel() {
		return new Veicolo();
	}

	@PostMapping("/add")
	public ResponseEntity<Veicolo> addVeicolo(@RequestBody Veicolo veicolo) {
		try {
			Veicolo savedVeicolo = veicoloService.saveVeicolo(veicolo);
			logger.info("Veicolo inserito: \n" + veicolo);
			return new ResponseEntity<Veicolo>(savedVeicolo, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Veicolo> updateVeicolo(@RequestBody Veicolo veicolo) {
		try {
			Veicolo savedVeicolo = veicoloService.updateVeicolo(veicolo);
			if (savedVeicolo == null)
				logger.info("Veicolo da aggiornare non trovato\n" + savedVeicolo);
			else
				logger.info("Veicolo aggiornato: \n" + savedVeicolo);
			return new ResponseEntity<Veicolo>(savedVeicolo, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Veicolo> deleteVeicolo(@RequestBody Veicolo veicolo) {
		try {
			Veicolo tempVeicolo = veicoloService.deleteVeicolo(veicolo);
			if (tempVeicolo == null)
				logger.info("Veicolo da eliminare non trovato\n");
			else
				logger.info("Veicolo eliminato: \n" + tempVeicolo);
			return new ResponseEntity<Veicolo>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getList")
	public ResponseEntity<List<Veicolo>> getListVeicolo() {
		try {
			List<Veicolo> listVeicolo = veicoloService.getListVeicolo();
			if (listVeicolo.isEmpty()) {
				logger.info("Lista veicoli vuota");
				return new ResponseEntity<List<Veicolo>>(HttpStatus.OK);
			}
			logger.info("Lista veicoli:");
			for (Veicolo veicolo : listVeicolo) {
				logger.info(veicolo.toString());
			}
			return new ResponseEntity<List<Veicolo>>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Veicolo> getVeicoloById(@PathVariable("id") int id) {
		try {
			Veicolo savedVeicolo = veicoloService.getVeicoloById(id);
			if (savedVeicolo == null) {
				logger.info("Nessun veicolo trovato con quell'ID");
			} else {
				logger.info("Veicolo cercato per id: \n" + savedVeicolo);
			}
			return new ResponseEntity<Veicolo>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getListByCategoria")
	public ResponseEntity<List<Veicolo>> getListByCategoria(@RequestHeader Categoria categoria) {
		try {
			List<Veicolo> listVeicolo = veicoloService.getListByCategoria(categoria);
			if (listVeicolo.isEmpty()) {
				logger.info("Lista veicoli per categoria vuota");
				return new ResponseEntity<List<Veicolo>>(HttpStatus.OK);
			}
			logger.info("Lista veicoli per categoria " + categoria + " :");
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
