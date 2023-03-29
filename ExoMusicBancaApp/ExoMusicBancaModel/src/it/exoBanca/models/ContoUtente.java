package it.exoBanca.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the conto_utente database table.
 * 
 */
@Entity
@Table(name = "conto_utente")
@NamedQuery(name = "ContoUtente.findAll", query = "SELECT c FROM ContoUtente c")
public class ContoUtente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conto")
	private int idConto;

	private String saldo;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	public ContoUtente() {
	}

	public int getIdConto() {
		return this.idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	public String getSaldo() {
		return this.saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}