package it.relatech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Veicolo;

;

@Repository
@Transactional
public  class VeicoloDaoImpl extends AbstractDao implements VeicoloDao {

	@Override
	public Veicolo saveVeicolo(Veicolo v) {
		persist(v);
		return v;	

	}
	
	@Override
	public Veicolo getVeicoloById(int id) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Veicolo) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veicolo> getListVeicolo() {
		return getSession().createCriteria(Veicolo.class).list();
	}

	@Override
	public Veicolo updateVeicolo(Veicolo v) {
		update(v);
		return null;
	}
	
	@Override
	public void deleteVeicolo(int id) {
		delete(getVeicolo(id));
	}

	@Override
	public Veicolo noleggia(Veicolo v) {
		Criteria criteria = getSession().createCriteria(Veicolo.class).add(Restrictions.eq("disponibile", true));
		return v;
	}
	
	@Override
	public Veicolo restituisci(Veicolo v) {
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
