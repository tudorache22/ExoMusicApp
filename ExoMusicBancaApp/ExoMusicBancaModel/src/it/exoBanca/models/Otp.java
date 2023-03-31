package it.exoBanca.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the otp database table.
 *
 */
@Entity
@Table(name="otp")
public class Otp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_otp")
	private int idOtp;

	@Column(name = "codice")
	private String codice;

	@Column(name = "creazione")
	private LocalDateTime creazione;

	@Column(name = "scadenza")
	private LocalDateTime scadenza;

	@Column(name="stato")
	private String stato;

	@ManyToOne
	@JoinColumn(name = "id_transazione")
	private Transazione transazione;

	public Otp() {
	}

	public int getIdOtp() {
		return idOtp;
	}

	public void setIdOtp(int idOtp) {
		this.idOtp = idOtp;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public LocalDateTime getCreazione() {
		return creazione;
	}

	public void setCreazione(LocalDateTime creazione) {
		this.creazione = creazione;
	}

	public LocalDateTime getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDateTime scadenza) {
		this.scadenza = scadenza;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
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