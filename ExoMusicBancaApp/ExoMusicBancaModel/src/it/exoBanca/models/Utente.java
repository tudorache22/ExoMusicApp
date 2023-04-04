package it.exoBanca.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
 * The persistent class for the utente database table.
 *
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_utente")
	private Integer idUtente;

	private String email;

	private String password;

	//bi-directional many-to-one association to Transazione
	@OneToMany(mappedBy="utente")
	@JsonbTransient
	private List<Transazione> listaTransazioni;

	//bi-directional many-to-one association to Anagrafica
	@ManyToOne
	@JoinColumn(name="id_anagrafica")
	private Anagrafica anagrafica;

	//bi-directional many-to-one association to Ruolo
	@ManyToOne
	@JoinColumn(name="id_ruolo")
	@JsonbTransient
	private Ruolo ruolo;

	public Utente() {
	}

	public Integer getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Transazione> getListaTransazioni() {
		return this.listaTransazioni;
	}

	public void setListaTransazioni(List<Transazione> transaziones) {
		this.listaTransazioni = transaziones;
	}

	public Anagrafica getAnagrafica() {
		return this.anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public Ruolo getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anagrafica, email, idUtente, password, ruolo, listaTransazioni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(anagrafica, other.anagrafica) && Objects.equals(email, other.email)
				&& idUtente == other.idUtente && Objects.equals(password, other.password)
				&& Objects.equals(ruolo, other.ruolo) && Objects.equals(listaTransazioni, other.listaTransazioni);
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", email=" + email + ", password=" + password + ", transaziones="
				+ listaTransazioni + ", anagrafica=" + anagrafica + ", ruolo=" + ruolo + "]";
	}

}