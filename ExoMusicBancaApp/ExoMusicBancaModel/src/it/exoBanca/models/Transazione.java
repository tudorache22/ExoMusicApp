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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="transazione")
public class Transazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transazione")
	private int idTransazione;

	@Column(name = "data")
	@JsonbDateFormat
	private Date data;

	@Column(name="importo")
	private String importo;

	@Column(name="stato")
	private String stato;

	@Column(name = "tipo_transazione")
	private String tipoTransazione;

	@Column(name="id_utente")
	private Integer idUtente;

	@ManyToOne
	@JsonbTransient
	private Utente utente;

	@OneToMany(mappedBy="transazione")
	private List<Otp> listaOtp;

	public Transazione() {
	}

	public int getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(int idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getImporto() {
		return importo;
	}

	public void setImporto(String importo) {
		this.importo = importo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTipoTransazione() {
		return tipoTransazione;
	}

	public void setTipoTransazione(String tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Otp> getListaOtp() {
		return listaOtp;
	}

	public void setListaOtp(List<Otp> listaOtp) {
		this.listaOtp = listaOtp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, idTransazione, importo, stato, tipoTransazione);
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
		return Objects.equals(data, other.data) && idTransazione == other.idTransazione
				&& Objects.equals(importo, other.importo) && Objects.equals(stato, other.stato)
				&& Objects.equals(tipoTransazione, other.tipoTransazione);
	}

	@Override
	public String toString() {
		return "Transazione [idTransazione=" + idTransazione + ", data=" + data + ", importo=" + importo + ", stato="
				+ stato + ", tipoTransazione=" + tipoTransazione + "]";
	}


}