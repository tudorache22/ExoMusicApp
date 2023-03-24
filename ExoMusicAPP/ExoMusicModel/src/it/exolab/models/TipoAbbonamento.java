package it.exolab.models;

public class TipoAbbonamento {

	private Integer idTipoAbbonamento;
	private String costo;
	private String informazioni;

	public Integer getIdTipoAbbonamento() {
		return idTipoAbbonamento;
	}

	public void setIdTipoAbbonamento(Integer idTipoAbbonamento) {
		this.idTipoAbbonamento = idTipoAbbonamento;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getInformazioni() {
		return informazioni;
	}

	public void setInformazioni(String informazioni) {
		this.informazioni = informazioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((costo == null) ? 0 : costo.hashCode());
		result = prime * result + ((idTipoAbbonamento == null) ? 0 : idTipoAbbonamento.hashCode());
		result = prime * result + ((informazioni == null) ? 0 : informazioni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAbbonamento other = (TipoAbbonamento) obj;
		if (costo == null) {
			if (other.costo != null)
				return false;
		} else if (!costo.equals(other.costo))
			return false;
		if (idTipoAbbonamento == null) {
			if (other.idTipoAbbonamento != null)
				return false;
		} else if (!idTipoAbbonamento.equals(other.idTipoAbbonamento))
			return false;
		if (informazioni == null) {
			if (other.informazioni != null)
				return false;
		} else if (!informazioni.equals(other.informazioni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoAbbonamento [idTipoAbbonamento=" + idTipoAbbonamento + ", costo=" + costo + ", informazioni="
				+ informazioni + "]";
	}

}
