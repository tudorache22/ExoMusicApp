package it.exoBanca.models;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the banca_riferimento database table.
 * 
 */
@Entity
@Table(name = "banca_riferimento")
@NamedQuery(name = "BancaRiferimento.findAll", query = "SELECT b FROM BancaRiferimento b")
public class BancaRiferimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_banca")
	private int idBanca;

	private String email;

	private String indirizzo;

	@Column(name = "nome_banca")
	private String nomeBanca;

	private String telefono;

	// bi-directional many-to-one association to Utente
	@OneToMany(mappedBy = "bancaRiferimento")
	@JsonbTransient
	private List<Utente> utentes;

	public BancaRiferimento() {
	}

	public int getIdBanca() {
		return this.idBanca;
	}

	public void setIdBanca(int idBanca) {
		this.idBanca = idBanca;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNomeBanca() {
		return this.nomeBanca;
	}

	public void setNomeBanca(String nomeBanca) {
		this.nomeBanca = nomeBanca;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Utente> getUtentes() {
		return this.utentes;
	}

	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	public Utente addUtente(Utente utente) {
		getUtentes().add(utente);
		utente.setBancaRiferimento(this);

		return utente;
	}

	public Utente removeUtente(Utente utente) {
		getUtentes().remove(utente);
		utente.setBancaRiferimento(null);

		return utente;
	}

}