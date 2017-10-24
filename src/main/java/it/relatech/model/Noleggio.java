package it.relatech.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Noleggio {

	@Id
	@GeneratedValue
	private int id;

	private LocalDate inizioNoleggio;

	private LocalDate fineNoleggio;

	private double costoNoleggio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
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
	public String toString() {
		return "Noleggio [id=" + id + ", inizioNoleggio=" + inizioNoleggio + ", fineNoleggio=" + fineNoleggio
				+ ", costoNoleggio=" + costoNoleggio + ", cliente=" + cliente + ", veicolo=" + veicolo + "]";
	}

}
