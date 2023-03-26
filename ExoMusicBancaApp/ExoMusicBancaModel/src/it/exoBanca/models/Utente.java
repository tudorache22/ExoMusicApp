package it.exoBanca.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int idUtente;

	private String cognome;

	private String email;

	private String nome;

	private String password;

	//bi-directional many-to-one association to ContoUtente
	@OneToMany(mappedBy="utente")
	private List<ContoUtente> contoUtentes;

	//bi-directional many-to-one association to Otp
	@OneToMany(mappedBy="utente")
	private List<Otp> otps;

	//bi-directional many-to-one association to Transazione
	@OneToMany(mappedBy="utente")
	private List<Transazione> transaziones;

	//bi-directional many-to-one association to BancaRiferimento
	@ManyToOne
	@JoinColumn(name="id_banca")
	private BancaRiferimento bancaRiferimento;

	public Utente() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ContoUtente> getContoUtentes() {
		return this.contoUtentes;
	}

	public void setContoUtentes(List<ContoUtente> contoUtentes) {
		this.contoUtentes = contoUtentes;
	}

	public ContoUtente addContoUtente(ContoUtente contoUtente) {
		getContoUtentes().add(contoUtente);
		contoUtente.setUtente(this);

		return contoUtente;
	}

	public ContoUtente removeContoUtente(ContoUtente contoUtente) {
		getContoUtentes().remove(contoUtente);
		contoUtente.setUtente(null);

		return contoUtente;
	}

	public List<Otp> getOtps() {
		return this.otps;
	}

	public void setOtps(List<Otp> otps) {
		this.otps = otps;
	}

	public Otp addOtp(Otp otp) {
		getOtps().add(otp);
		otp.setUtente(this);

		return otp;
	}

	public Otp removeOtp(Otp otp) {
		getOtps().remove(otp);
		otp.setUtente(null);

		return otp;
	}

	public List<Transazione> getTransaziones() {
		return this.transaziones;
	}

	public void setTransaziones(List<Transazione> transaziones) {
		this.transaziones = transaziones;
	}

	public Transazione addTransazione(Transazione transazione) {
		getTransaziones().add(transazione);
		transazione.setUtente(this);

		return transazione;
	}

	public Transazione removeTransazione(Transazione transazione) {
		getTransaziones().remove(transazione);
		transazione.setUtente(null);

		return transazione;
	}

	public BancaRiferimento getBancaRiferimento() {
		return this.bancaRiferimento;
	}

	public void setBancaRiferimento(BancaRiferimento bancaRiferimento) {
		this.bancaRiferimento = bancaRiferimento;
	}

}