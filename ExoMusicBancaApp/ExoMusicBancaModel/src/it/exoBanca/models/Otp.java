package it.exoBanca.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the otp database table.
 * 
 */
@Entity
@NamedQuery(name="Otp.findAll", query="SELECT o FROM Otp o")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_otp")
	private int idOtp;

	@Column(name="codice_otp")
	private String codiceOtp;

	@Temporal(TemporalType.DATE)
	@Column(name="data_creazione")
	private Date dataCreazione;

	@Temporal(TemporalType.DATE)
	@Column(name="data_scadenza")
	private Date dataScadenza;

	private String stato;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
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

	public Date getDataCreazione() {
		return this.dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
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