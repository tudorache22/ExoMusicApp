package it.exoBanca.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the transazione database table.
 * 
 */
@Entity
@NamedQuery(name = "Transazione.findAll", query = "SELECT t FROM Transazione t")
public class Transazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transazione")
	private int idTransazione;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_transazione")
	private Date dataTransazione;

	private String importo;

	private String informazioni;

	@Column(name = "tipo_transazione")
	private String tipoTransazione;

	// bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;

	public Transazione() {
	}

	public int getIdTransazione() {
		return this.idTransazione;
	}

	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Date getDataTransazione() {
		return this.dataTransazione;
	}

	public void setDataTransazione(Date dataTransazione) {
		this.dataTransazione = dataTransazione;
	}

	public String getImporto() {
		return this.importo;
	}

	public void setImporto(String importo) {
		this.importo = importo;
	}

	public String getInformazioni() {
		return this.informazioni;
	}

	public void setInformazioni(String informazioni) {
		this.informazioni = informazioni;
	}

	public String getTipoTransazione() {
		return this.tipoTransazione;
	}

	public void setTipoTransazione(String tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}