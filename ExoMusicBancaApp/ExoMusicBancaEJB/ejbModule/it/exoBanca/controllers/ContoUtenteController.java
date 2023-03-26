package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.ContoUtenteControllerInterface;
import it.exoBanca.models.ContoUtente;

@Stateless(name = "ContoUtenteController")
@LocalBean
public class ContoUtenteController implements ContoUtenteControllerInterface {

	@Override
	public ContoUtente insert(ContoUtente model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContoUtente update(ContoUtente model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContoUtente findById(Integer idModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContoUtente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ContoUtente model) {
		// TODO Auto-generated method stub

	}

}
