package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.Anagrafica;

@Local
public interface AnagraficaControllerInterface {

	Anagrafica insert(Anagrafica anagrafica);

	Anagrafica update(Anagrafica anagrafica);

	void delete(Anagrafica anagrafica);

	Anagrafica findById(Integer idAnagrafica);

	List<Anagrafica> findAll();
}
