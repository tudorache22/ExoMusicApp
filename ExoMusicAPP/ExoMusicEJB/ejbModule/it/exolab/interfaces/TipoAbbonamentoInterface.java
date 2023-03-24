package it.exolab.interfaces;

import javax.ejb.Local;

import it.exolab.models.TipoAbbonamento;

@Local
public interface TipoAbbonamentoInterface {
	public TipoAbbonamento findById(Integer id);

}
