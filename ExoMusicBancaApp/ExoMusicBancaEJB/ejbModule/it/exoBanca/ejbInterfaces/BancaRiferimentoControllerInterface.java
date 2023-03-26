package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.BancaRiferimento;

@Local
public interface BancaRiferimentoControllerInterface {

	BancaRiferimento insert(BancaRiferimento model);

	BancaRiferimento update(BancaRiferimento model);

	BancaRiferimento findById(Integer idModel);

	List<BancaRiferimento> findAll();

	void delete(BancaRiferimento model);

}
