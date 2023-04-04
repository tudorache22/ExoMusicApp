package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import it.exoBanca.ejbInterfaces.UtenteControllerInterface;
import it.exoBanca.models.Utente;
import it.exolab.costanti.Const;

@Stateless(name = "UtenteControllerInterface")
@LocalBean
public class UtenteEJB extends BaseEJB<Utente> implements UtenteControllerInterface {

	@Override
	public Utente insert(Utente utente) {
		try {
			createEntityManager();
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(getEntityManager().contains(utente) ? utente : getEntityManager().merge(utente));
			System.out.println(utente);
//			operations.insertContoCorrente(utente);
			getEntityManager().getTransaction().commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			getEntityManager().close();
		}
		return null;

	}

	@Override
	public Utente update(Utente utente) {

		try {
			createEntityManager();
			getEntityManager().getTransaction().begin();
			Utente oldUser = findById(utente.getIdUtente());
			operations.updateContoCorrente(oldUser, utente);
			getEntityManager().getTransaction().commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			getEntityManager().close();
		}
		return null;
	}

	@Override
	public void delete(Utente utente) {
		try {
			createEntityManager();
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(getEntityManager().contains(utente) ? utente : getEntityManager().merge(utente));
			operations.deleteContoCorrente(utente);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			getEntityManager().flush();
			getEntityManager().close();
		}
	}

	@Override
	public Utente findById(Integer id) {
		return super.findById(Utente.class, id);
	}

	@Override
	public List<Utente> findAll() {
		return super.findAll(Const.TABELLA_UTENTE);
	}

	@Override
	public Utente findByEmailPassword(Utente utente) {

		try {
			createEntityManager();
			getEntityManager().getTransaction().begin();
			Query query = getEntityManager().createNativeQuery(Const.QUERY_LOGIN
					.replace(":placeEmail:", utente.getEmail()).replace(":placePassword:", utente.getPassword()),
					Utente.class);
			Utente utenteLogin = (Utente) query.getSingleResult();
			getEntityManager().getTransaction().commit();
			return utenteLogin;
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			getEntityManager().close();
		}

		return null;
	}

}
