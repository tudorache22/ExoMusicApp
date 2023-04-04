package it.exoBanca.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the ruolo database table.
 *
 */
@Entity
@NamedQuery(name="Ruolo.findAll", query="SELECT r FROM Ruolo r")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ruolo")
	private Integer idRuolo;

	private String denominazione;

	//bi-directional many-to-one association to Utente
	@OneToMany(mappedBy="ruolo")
	private List<Utente> utentes;

	public Ruolo() {
	}

	public int getIdRuolo() {
		return this.idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDenominazione() {
		return this.denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public List<Utente> getUtentes() {
		return this.utentes;
	}

	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	public Utente addUtente(Utente utente) {
		getUtentes().add(utente);
		utente.setRuolo(this);

		return utente;
	}

	public Utente removeUtente(Utente utente) {
		getUtentes().remove(utente);
		utente.setRuolo(null);

		return utente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(denominazione, idRuolo, utentes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruolo other = (Ruolo) obj;
		return Objects.equals(denominazione, other.denominazione) && Objects.equals(idRuolo, other.idRuolo)
				&& Objects.equals(utentes, other.utentes);
	}

	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", denominazione=" + denominazione + ", utentes=" + utentes + "]";
	}

}