package it.relatech.model;

import java.time.LocalDate;
import it.relatech.serializer.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Noleggio {

	@Id
	@GeneratedValue
	private int id;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate inizioNoleggio;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate fineNoleggio;

	private double costoNoleggio;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "VEICOLO_ID")
	private Veicolo veicolo;

	public Noleggio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getInizioNoleggio() {
		return inizioNoleggio;
	}

	public void setInizioNoleggio(LocalDate inizioNoleggio) {
		this.inizioNoleggio = inizioNoleggio;
	}

	public LocalDate getFineNoleggio() {
		return fineNoleggio;
	}

	public void setFineNoleggio(LocalDate fineNoleggio) {
		this.fineNoleggio = fineNoleggio;
	}

	public double getCostoNoleggio() {
		return costoNoleggio;
	}

	public void setCostoNoleggio(double costoNoleggio) {
		this.costoNoleggio = costoNoleggio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		long temp;
		temp = Double.doubleToLongBits(costoNoleggio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fineNoleggio == null) ? 0 : fineNoleggio.hashCode());
		result = prime * result + ((inizioNoleggio == null) ? 0 : inizioNoleggio.hashCode());
		result = prime * result + ((veicolo == null) ? 0 : veicolo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noleggio other = (Noleggio) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (Double.doubleToLongBits(costoNoleggio) != Double.doubleToLongBits(other.costoNoleggio))
			return false;
		if (fineNoleggio == null) {
			if (other.fineNoleggio != null)
				return false;
		} else if (!fineNoleggio.equals(other.fineNoleggio))
			return false;
		if (inizioNoleggio == null) {
			if (other.inizioNoleggio != null)
				return false;
		} else if (!inizioNoleggio.equals(other.inizioNoleggio))
			return false;
		if (veicolo == null) {
			if (other.veicolo != null)
				return false;
		} else if (!veicolo.equals(other.veicolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noleggio [id=" + id + ", inizioNoleggio=" + inizioNoleggio + ", fineNoleggio=" + fineNoleggio
				+ ", costoNoleggio=" + costoNoleggio + ", cliente=" + cliente + ", veicolo=" + veicolo + "]";
	}

}
