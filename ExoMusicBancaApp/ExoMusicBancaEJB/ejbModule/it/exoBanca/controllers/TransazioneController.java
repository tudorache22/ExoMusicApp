package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.TransazioneControllerInterface;
import it.exoBanca.models.Transazione;

@Stateless(name = "TransazioneController")
@LocalBean
public class TransazioneController implements TransazioneControllerInterface {

	@Override
	public Transazione insert(Transazione model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transazione update(Transazione model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transazione findById(Integer idModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transazione> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Transazione model) {
		// TODO Auto-generated method stub

	}

}
