package it.relatech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Veicolo {

	@Id
	@GeneratedValue
	private int id;
	
	private String marca;
	
	private String modello;
	
	private String targa;
	
	@Enumerated(EnumType.ORDINAL)
	private Alimentazione alimentazione;
	
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	
	@Enumerated(EnumType.ORDINAL)
	private Colore colore;
	
	@OneToMany(mappedBy="veicolo")
	private List<Noleggio> listNoleggio;

	
	public Veicolo() {
		listNoleggio = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Alimentazione getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public List<Noleggio> getListNoleggio() {
		return listNoleggio;
	}

	public void setListNoleggio(List<Noleggio> listNoleggio) {
		this.listNoleggio = listNoleggio;
	}

	@Override
	public String toString() {
		return "Veicolo [id=" + id + ", marca=" + marca + ", modello=" + modello + ", targa=" + targa
				+ ", alimentazione=" + alimentazione + ", categoria=" + categoria + ", colore=" + colore
				+ ", listNoleggio=" + listNoleggio + "]";
	}

}
