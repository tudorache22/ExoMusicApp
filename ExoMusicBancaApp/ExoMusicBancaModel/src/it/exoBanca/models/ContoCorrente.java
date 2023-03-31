package it.exoBanca.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conto_corrente")
public class ContoCorrente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_conto")
	private String numeroConto;

	@Column(name="data_scadenza")
	private LocalDateTime dataScadenza;

	@Column(name="saldo")
	private Float saldo;

	public String getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public LocalDateTime getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDateTime dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Float getSaldo() {
		return saldo;
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
