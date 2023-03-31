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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the utente database table.
 *
 */
@Entity
@Table(name="utente")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private Integer idUtente;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="id_ruolo")
	private Integer idRuolo;

	@OneToOne
	@JsonbTransient
	private Anagrafica anagrafica;

	@OneToMany(mappedBy="utente")
	@JsonbTransient
	private List<Transazione> listaTransazioni;

	@OneToOne
	private ContoCorrente contoCorrente;

	public Utente() {
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	public List<Transazione> getListaTransazioni() {
		return listaTransazioni;
	}

	public void setListaTransazioni(List<Transazione> listaTransazioni) {
		this.listaTransazioni = listaTransazioni;
	}

	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anagrafica, contoCorrente, email, idUtente, listaTransazioni, password);
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
		return Objects.equals(anagrafica, other.anagrafica) && Objects.equals(contoCorrente, other.contoCorrente)
				&& Objects.equals(email, other.email) && Objects.equals(idUtente, other.idUtente)
				&& Objects.equals(listaTransazioni, other.listaTransazioni) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", email=" + email + ", password=" + password + ", anagrafica="
				+ anagrafica + ", listaTransazioni=" + listaTransazioni + ", contoCorrente=" + contoCorrente + "]";
	}



}