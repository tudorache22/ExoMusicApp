package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.BancaRiferimentoControllerInterface;
import it.exoBanca.models.BancaRiferimento;

@Stateless(name = "BancaRiferimentoController")
@LocalBean
public class BancaRiferimentoController implements BancaRiferimentoControllerInterface {

	@Override
	public BancaRiferimento insert(BancaRiferimento model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BancaRiferimento update(BancaRiferimento model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BancaRiferimento findById(Integer idModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BancaRiferimento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(BancaRiferimento model) {
		// TODO Auto-generated method stub

	}

}
