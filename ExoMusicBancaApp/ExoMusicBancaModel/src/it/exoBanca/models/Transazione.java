package it.exoBanca.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the transazione database table.
 *
 */
@Entity
@NamedQuery(name="Transazione.findAll", query="SELECT t FROM Transazione t")
public class Transazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_transazione")
	private Integer idTransazione;

	@JsonbDateFormat
	private Date data;

	private Float importo;

	private Integer stato;

	public static final Integer TRANSAZIONE_ATTIVA = 1;
	public static final Integer TRANSAZIONE_SCADUTA = 0;

	@Column(name="tipo_transazione")
	private String tipoTransazione;

	//bi-directional many-to-one association to Otp
	@OneToMany(mappedBy="transazione")
	@JsonbTransient
	private List<Otp> otps;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	@JsonbTransient
	private Utente utente;

	public Transazione() {
	}

	public Integer getIdTransazione() {
		return this.idTransazione;
	}

	public void setIdTransazione(Integer idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getImporto() {
		return this.importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public int getStato() {
		return this.stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}

	public String getTipoTransazione() {
		return this.tipoTransazione;
	}

	public void setTipoTransazione(String tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	public List<Otp> getOtps() {
		return this.otps;
	}

	public void setOtps(List<Otp> otps) {
		this.otps = otps;
	}

	public Otp addOtp(Otp otp) {
		getOtps().add(otp);
		otp.setTransazione(this);

		return otp;
	}

	public Otp removeOtp(Otp otp) {
		getOtps().remove(otp);
		otp.setTransazione(null);

		return otp;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, idTransazione, importo, otps, stato, tipoTransazione, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transazione other = (Transazione) obj;
		return Objects.equals(data, other.data) && Objects.equals(idTransazione, other.idTransazione)
				&& Objects.equals(importo, other.importo) && Objects.equals(otps, other.otps)
				&& Objects.equals(stato, other.stato) && Objects.equals(tipoTransazione, other.tipoTransazione)
				&& Objects.equals(utente, other.utente);
	}

	@Override
	public String toString() {
		return "Transazione [idTransazione=" + idTransazione + ", data=" + data + ", importo=" + importo + ", stato="
				+ stato + ", tipoTransazione=" + tipoTransazione + ", otps=" + otps + ", utente=" + utente + "]";
	}

}