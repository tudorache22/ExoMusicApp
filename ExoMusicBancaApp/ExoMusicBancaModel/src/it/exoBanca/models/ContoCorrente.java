package it.exoBanca.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the conto_corrente database table.
 *
 */
@Entity
@Table(name="conto_corrente")
@NamedQuery(name="ContoCorrente.findAll", query="SELECT c FROM ContoCorrente c")
public class ContoCorrente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_conto")
	private String numeroConto;

	@JsonbDateFormat
	@Column(name="data_scadenza")
	private Date dataScadenza;

	private Float saldo;

	public ContoCorrente() {
	}

	public String getNumeroConto() {
		return this.numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public Date getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Float getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataScadenza, numeroConto, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return Objects.equals(dataScadenza, other.dataScadenza) && Objects.equals(numeroConto, other.numeroConto)
				&& Objects.equals(saldo, other.saldo);
	}

	@Override
	public String toString() {
		return "ContoCorrente [numeroConto=" + numeroConto + ", dataScadenza=" + dataScadenza + ", saldo=" + saldo
				+ "]";
	}

}