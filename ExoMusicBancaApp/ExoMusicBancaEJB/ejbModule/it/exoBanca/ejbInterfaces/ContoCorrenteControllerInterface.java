package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.ContoCorrente;

@Local
public interface ContoCorrenteControllerInterface {

	ContoCorrente insert(ContoCorrente contoCorrente);

	ContoCorrente update(ContoCorrente contoCorrente);

	void delete(ContoCorrente contoCorrente);

	ContoCorrente findByNumeroConto(String numeroConto);

	List<ContoCorrente> findAll();
}
