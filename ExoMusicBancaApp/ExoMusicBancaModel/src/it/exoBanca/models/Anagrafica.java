package it.exoBanca.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="anagrafica")
public class Anagrafica {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_anagrafica")
	private Integer idAnagrafica;

	@Column(name="nome")
	private String nome;

	@Column(name="cognome")
	private String cognome;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	@Column(name="luogo_nascita")
	private String luogoNascita;

	@Column(name="provincia")
	private String provincia;

	@Column(name="sesso")
	private Character sesso;

	public static final Character SESSO_UOMO = 'M';
	public static final Character SESSO_DONNA = 'F';

	public Anagrafica() {

	}

	public Anagrafica(Integer idAnagrafica, String nome, String cognome, String codiceFiscale, String luogoNascita,String provincia, Character sesso) {
		super();
		this.idAnagrafica = idAnagrafica;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.luogoNascita = luogoNascita;
		this.provincia = provincia;
		this.sesso = sesso;
	}



	public Integer getIdAnagrafica() {
		return idAnagrafica;
	}
	public void setIdAnagrafica(Integer idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Character getSesso() {
		return sesso;
	}
	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}


}
