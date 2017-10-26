package it.relatech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

@Repository
@Transactional
public class VeicoloDaoImpl extends AbstractDao implements VeicoloDao {

	@Override
	public Veicolo saveVeicolo(Veicolo v) {
		persist(v);
		return v;
	}

	@Override
	public Veicolo getVeicoloById(int id) {
		return (Veicolo) getSession().createCriteria(Veicolo.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veicolo> getListVeicoli() {
		return (List<Veicolo>) getSession().createCriteria(Veicolo.class).list();
	}

	@Override
	public Veicolo updateVeicolo(Veicolo v) {
		update(v);
		return v;
	}

	@Override
	public void deleteVeicolo(Veicolo veicolo) {
		List<Veicolo> listVeicoli = getListVeicoli();
		Veicolo temp = null;
		for (Veicolo veicolo2 : listVeicoli) {
			if (veicolo.equals(veicolo2))
				temp = veicolo2;
		}

		delete(temp);
	}

	@Override
	public List<Veicolo> getListByCategoria(Categoria categoria) {
		return (List<Veicolo>) getSession().createCriteria(Veicolo.class).add(Restrictions.eq("categoria", categoria)).list();
	}

}
