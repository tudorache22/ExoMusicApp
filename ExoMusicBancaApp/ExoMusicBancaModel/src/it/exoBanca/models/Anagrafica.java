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
 * The persistent class for the anagrafica database table.
 *
 */
@Entity
@NamedQuery(name="Anagrafica.findAll", query="SELECT a FROM Anagrafica a")
public class Anagrafica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anagrafica")
	private Integer idAnagrafica;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@JsonbDateFormat
	@Column(name="data_nascita")
	private Date dataNascita;

	@Column(name="luogo_nascita")
	private String luogoNascita;

	private String nome;

	private String provincia;

	private Character sesso;

	public static final Character SESSO_UOMO = 'M';
	public static final Character SESSO_DONNA = 'F';

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;


	public Anagrafica() {
	}

	public Integer getIdAnagrafica() {
		return this.idAnagrafica;
	}

	public void setIdAnagrafica(Integer idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Character getSesso() {
		return this.sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscale, cognome, dataNascita, idAnagrafica, luogoNascita, nome, provincia, sesso,
				utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagrafica other = (Anagrafica) obj;
		return Objects.equals(codiceFiscale, other.codiceFiscale) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataNascita, other.dataNascita) && Objects.equals(idAnagrafica, other.idAnagrafica)
				&& Objects.equals(luogoNascita, other.luogoNascita) && Objects.equals(nome, other.nome)
				&& Objects.equals(provincia, other.provincia) && Objects.equals(sesso, other.sesso)
				&& Objects.equals(utente, other.utente);
	}

	@Override
	public String toString() {
		return "Anagrafica [idAnagrafica=" + idAnagrafica + ", codiceFiscale=" + codiceFiscale + ", cognome=" + cognome
				+ ", dataNascita=" + dataNascita + ", luogoNascita=" + luogoNascita + ", nome=" + nome + ", provincia="
				+ provincia + ", sesso=" + sesso + ", utente=" + utente +"]";
	}

}