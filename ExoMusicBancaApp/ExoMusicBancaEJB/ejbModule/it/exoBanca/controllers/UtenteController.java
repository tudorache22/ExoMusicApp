package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.UtenteControllerInterface;
import it.exoBanca.models.Utente;

@Stateless(name = "UtenteController")
@LocalBean
public class UtenteController implements UtenteControllerInterface {

	@Override
	public Utente insert(Utente model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente update(Utente model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findById(Integer idModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utente model) {
		// TODO Auto-generated method stub

	}

}
