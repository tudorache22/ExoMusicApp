package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.exoBanca.ejbInterfaces.ContoUtenteControllerInterface;
import it.exoBanca.models.ContoUtente;

@Stateless(name = "ContoUtenteControllerInterface")
@LocalBean
public class ContoUtenteController extends BaseController implements ContoUtenteControllerInterface {

	final static Logger logger = Logger.getLogger(ContoUtenteController.class);

	@Override
	public ContoUtente insert(ContoUtente contoUtente) {
		logger.info("sei nel ContoUtente Controller insert >>>" + contoUtente);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(contoUtente)) {
				contoUtente = entityManager.merge(contoUtente);
			}
			entityManager.persist(contoUtente);
			transaction.commit();
			return contoUtente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	@Override
	public ContoUtente update(ContoUtente contoUtente) {
		logger.info("sei nel ContoUtente Controller update >>>" + contoUtente);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(contoUtente);
			transaction.commit();
			return contoUtente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public ContoUtente findById(Integer idContoUtente) {
		logger.info("sei nel ContoUtente Controller findById >>>" + idContoUtente);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			ContoUtente contoUtente = new ContoUtente();
			contoUtente = entityManager.find(ContoUtente.class, idContoUtente);
			transaction.commit();
			return contoUtente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<ContoUtente> findAll() {
		logger.info("sei nel ContoUtente Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<ContoUtente> listaConti = new ArrayList<ContoUtente>();
			Query query = entityManager.createNativeQuery("SELECT * FROM banca_riferimento");
			listaConti.addAll((List<ContoUtente>) query.getResultList());
			transaction.commit();
			return listaConti;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void delete(ContoUtente contoUtente) {
		logger.info("sei nel ContoUtente Controller delete >>>" + contoUtente);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(contoUtente) ? contoUtente : entityManager.merge(contoUtente));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}
}
