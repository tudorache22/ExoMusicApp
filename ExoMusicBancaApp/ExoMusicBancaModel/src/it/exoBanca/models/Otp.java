package it.exoBanca.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the otp database table.
 * 
 */
@Entity
@NamedQuery(name = "Otp.findAll", query = "SELECT o FROM Otp o")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_otp")
	private int idOtp;

	@Column(name = "codice_otp")
	private String codiceOtp;

	@Column(name = "data_creazione")
	private LocalDateTime dataCreazione;

	@Column(name = "data_scadenza")
	private LocalDateTime dataScadenza;

	private String stato;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	public Otp() {
	}

	public int getIdOtp() {
		return this.idOtp;
	}

	public void setIdOtp(int idOtp) {
		this.idOtp = idOtp;
	}

	public String getCodiceOtp() {
		return this.codiceOtp;
	}

	public void setCodiceOtp(String codiceOtp) {
		this.codiceOtp = codiceOtp;
	}

	public LocalDateTime getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDateTime getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(LocalDateTime dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}