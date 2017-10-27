package it.relatech.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.relatech.config.AppConfig;
import it.relatech.config.HibernateConfiguration;
import it.relatech.model.Alimentazione;
import it.relatech.model.Categoria;
import it.relatech.model.Colore;
import it.relatech.model.Veicolo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class })
@WebAppConfiguration
@Transactional
public class VeicoloTest {
	
	
	 
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/**
	 * Test for persist on db. At the end of test the transaction is rollabacked
	 * and the record is cancelled from the db.
	 * 
	 * @throws Exception
	 */
	@Test
	//@Rollback(false)         not delete
	public void testSaveVeicolo() throws Exception {
		
		Veicolo veicolo = new Veicolo();
			
		veicolo.setMarca("Ferrari");
		veicolo.setModello("TestaRossa");
		veicolo.setTarga("abc");
		veicolo.setAlimentazione(Alimentazione.BENZINA);
		veicolo.setColore(Colore.ROSSO);
		veicolo.setCategoria(Categoria.SUPERCAR);
		
		
		mockMvc.perform(
				post("/veicolo/add").content(mapper.writeValueAsString(veicolo)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated());
	}
	
	/**
	 * Test for update on db. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateVeicolo() throws Exception {
		
		Veicolo veicolo = new Veicolo();
		
		veicolo.setMarca("Ferrari");
		veicolo.setModello("TestaRossa");
		veicolo.setTarga("abc");
		veicolo.setAlimentazione(Alimentazione.BENZINA);
		veicolo.setColore(Colore.ROSSO);
		veicolo.setCategoria(Categoria.SUPERCAR);
		
		
		mockMvc.perform(
				post("/veicolo/update").content(mapper.writeValueAsString(veicolo)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}
	
}
