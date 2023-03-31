package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.ContoCorrenteControllerInterface;
import it.exoBanca.models.ContoCorrente;
import it.exolab.costanti.Const;

@Stateless(name="ContoCorrenteControllerInterface")
@LocalBean
public class ContoCorrenteEJB extends BaseEJB<ContoCorrente> implements ContoCorrenteControllerInterface{

	@Override
	public ContoCorrente insert(ContoCorrente model) {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public ContoCorrente update(ContoCorrente model) {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public void delete(ContoCorrente model) {
		// TODO Auto-generated method stub
		super.delete(model);
	}

	@Override
	public ContoCorrente findById(Integer numeroConto) {
		// TODO Auto-generated method stub
		return super.findById(ContoCorrente.class, numeroConto);
	}

	@Override
	public List<ContoCorrente> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Const.TABELLA_CONTO_CORRENTE);
	}


}
