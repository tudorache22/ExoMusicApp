package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.ContoUtente;

@Local
public interface ContoUtenteControllerInterface {

	ContoUtente insert(ContoUtente model);

	ContoUtente update(ContoUtente model);

	ContoUtente findById(Integer idModel);

	List<ContoUtente> findAll();

	void delete(ContoUtente model);

}
