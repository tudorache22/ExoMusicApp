package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import it.exoBanca.ejbInterfaces.UtenteControllerInterface;
import it.exoBanca.models.Utente;
import it.exolab.costanti.Const;

@Stateless(name="UtenteControllerInterface")
@LocalBean
public class UtenteEJB extends BaseEJB<Utente> implements UtenteControllerInterface{

	@Override
	public Utente insert(Utente model) {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public Utente update(Utente model) {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public void delete(Utente model) {
		// TODO Auto-generated method stub
		super.delete(model);
	}

	@Override
	public Utente findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Utente.class, id);
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Const.TABELLA_UTENTE);
	}

	@Override
	public Utente findByEmailPassword(Utente utente) {

		try {
			getEntityManager().getTransaction().begin();
			Query query = getEntityManager().createNativeQuery(Const.QUERY_LOGIN
					.replace(":placeEmail:", utente.getEmail()).replace(":placePassword:", utente.getPassword()));

			Utente model = (Utente) query.getSingleResult();
			getEntityManager().getTransaction().commit();
			return model;
		}catch(Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			getEntityManager().close();
		}

		return null;
	}

}
