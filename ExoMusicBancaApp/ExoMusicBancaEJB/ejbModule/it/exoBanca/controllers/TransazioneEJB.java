package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.TransazioneControllerInterface;
import it.exoBanca.models.Transazione;
import it.exolab.costanti.Const;

@Stateless(name="TransazioneControllerInterface")
@LocalBean
public class TransazioneEJB extends BaseEJB<Transazione> implements TransazioneControllerInterface{

	@Override
	public Transazione insert(Transazione model) {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public Transazione update(Transazione model) {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public void delete(Transazione model) {
		// TODO Auto-generated method stub
		super.delete(model);
	}

	@Override
	public Transazione findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Transazione.class, id);
	}

	@Override
	public List<Transazione> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Const.TABELLA_TRANSAZIONE);
	}

}
