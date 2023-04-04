package it.exoBanca.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.json.bind.annotation.JsonbDateFormat;
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
@NamedQuery(name="Otp.findAll", query="SELECT o FROM Otp o")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_otp")
	private Integer idOtp;

	private String codice;

	@JsonbDateFormat
	private Date creazione;

	@JsonbDateFormat
	private Date scadenza;

	//bi-directional many-to-one association to Transazione
	@ManyToOne
	@JoinColumn(name="id_transazione")
	private Transazione transazione;

	public Otp() {
	}

	public int getIdOtp() {
		return this.idOtp;
	}

	public void setIdOtp(int idOtp) {
		this.idOtp = idOtp;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Date getCreazione() {
		return this.creazione;
	}

	public void setCreazione(Date creazione) {
		this.creazione = creazione;
	}

	public Date getScadenza() {
		return this.scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public Transazione getTransazione() {
		return this.transazione;
	}

	public void setTransazione(Transazione transazione) {
		this.transazione = transazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice, creazione, idOtp, scadenza, transazione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Otp other = (Otp) obj;
		return Objects.equals(codice, other.codice) && Objects.equals(creazione, other.creazione)
				&& Objects.equals(idOtp, other.idOtp) && Objects.equals(scadenza, other.scadenza)
				&& Objects.equals(transazione, other.transazione);
	}

	@Override
	public String toString() {
		return "Otp [idOtp=" + idOtp + ", codice=" + codice + ", creazione=" + creazione + ", scadenza=" + scadenza
				+ ", transazione=" + transazione + "]";
	}

}