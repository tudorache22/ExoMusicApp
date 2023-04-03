package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.AnagraficaControllerInterface;
import it.exoBanca.models.Anagrafica;
import it.exolab.costanti.Const;
import it.exolab.utility.CodiceFiscaleUtility;

@Stateless(name="AnagraficaControllerInterface")
@LocalBean
public class AnagraficaEJB extends BaseEJB<Anagrafica> implements AnagraficaControllerInterface{

	@Override
	public Anagrafica insert(Anagrafica model) {
		// TODO Auto-generated method stub
		return CodiceFiscaleUtility.check(model) ? super.insert(model) : null;
	}

	@Override
	public Anagrafica update(Anagrafica model) {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public void delete(Anagrafica model) {
		// TODO Auto-generated method stub
		super.delete(model);
	}

	@Override
	public Anagrafica findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Anagrafica.class, id);
	}

	@Override
	public List<Anagrafica> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Const.TABELLA_ANAGRAFICA);
	}

}
