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
import it.relatech.model.Veicolo;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private final Logger logger = Logger.getLogger(ClienteController.class.getName());
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/getModel")
	public Cliente getClienteModel() {
		return new Cliente();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
		try {
			Cliente savedCliente = clienteService.addCliente(cliente);
			logger.info("Cliente aggiunto: \n" + savedCliente);
			return new ResponseEntity<Cliente>(savedCliente, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
		try {
			Cliente savedCliente = clienteService.updateCliente(cliente);
			logger.info("Cliente aggiornato: \n" + savedCliente);
			return new ResponseEntity<Cliente>(savedCliente, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Cliente> deleteCliente(@RequestBody Cliente cliente){
		try {
			Cliente savedCliente = clienteService.deleteCliente(cliente);
			logger.info("Cliente eliminato: \n" + savedCliente);
			return new ResponseEntity<Cliente>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getList")
	public ResponseEntity<List<Cliente>> getListCliente(){
		try {
			List<Cliente> listCliente = clienteService.getListCliente();
			logger.info("Cliente aggiornato: \n" + listCliente);
			return new ResponseEntity<List<Cliente>>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Errore: " + e);
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}


































