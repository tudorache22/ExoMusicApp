package it.exoBanca.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="otp")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_otp")
	private Integer idOtp;

	@Column(name = "codice")
	private String codice;

	@Column(name = "creazione")
	@JsonbDateFormat(value="YYYY-MM-DD")
	private LocalDate creazione;

	@Column(name = "scadenza")
	@JsonbDateFormat(value="YYYY-MM-DD")
	private LocalDate scadenza;

	@Column(name="stato")
	private String stato;

	@Column(name="id_transazione")
	private Integer idTransazione;

	@ManyToOne
	private Transazione transazione;

	public static final String STATO_ATTIVO = "attivo";
	public static final String STATO_SCADUTO = "scaduto";

	public Otp() {
	}

	public Integer getIdOtp() {
		return idOtp;
	}

	public void setIdOtp(Integer idOtp) {
		this.idOtp = idOtp;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public LocalDate getCreazione() {
		return creazione;
	}

	public void setCreazione(LocalDate creazione) {
		this.creazione = creazione;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Integer getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(Integer idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Transazione getTransazione() {
		return transazione;
	}

	public void setTransazione(Transazione transazione) {
		this.transazione = transazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice, creazione, idOtp, scadenza, stato, transazione);
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
				&& idOtp == other.idOtp && Objects.equals(scadenza, other.scadenza)
				&& Objects.equals(stato, other.stato) && Objects.equals(transazione, other.transazione);
	}

	@Override
	public String toString() {
		return "Otp [idOtp=" + idOtp + ", codice=" + codice + ", creazione=" + creazione + ", scadenza=" + scadenza
				+ ", stato=" + stato + ", transazione=" + transazione + "]";
	}



}