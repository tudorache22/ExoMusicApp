package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.exoBanca.ejbInterfaces.BancaRiferimentoControllerInterface;
import it.exoBanca.models.BancaRiferimento;

@Stateless(name = "BancaRiferimentoControllerInterface")
@LocalBean
public class BancaRiferimentoController extends BaseController implements BancaRiferimentoControllerInterface {

	final static Logger logger = Logger.getLogger(BancaRiferimentoController.class);

	@Override
	public BancaRiferimento insert(BancaRiferimento bancaRiferimento) {
		logger.info("sei nel BancaRiferimento Controller insert >>>" + bancaRiferimento);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(bancaRiferimento)) {
				bancaRiferimento = entityManager.merge(bancaRiferimento);
			}
			entityManager.persist(bancaRiferimento);
			transaction.commit();
			return bancaRiferimento;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			closeEntityManager();
		}
		return null;
	}

	@Override
	public BancaRiferimento update(BancaRiferimento bancaRiferimento) {
		logger.info("sei nel BancaRiferimento Controller update >>>" + bancaRiferimento);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(bancaRiferimento);
			transaction.commit();
			return bancaRiferimento;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public BancaRiferimento findById(Integer idBancaRiferimento) {
		logger.info("sei nel BancaRiferimento Controller findById >>>" + idBancaRiferimento);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			BancaRiferimento bancaRiferimento = new BancaRiferimento();
			bancaRiferimento = entityManager.find(BancaRiferimento.class, idBancaRiferimento);
			transaction.commit();
			return bancaRiferimento;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public List<BancaRiferimento> findAll() {
		logger.info("sei nel BancaRiferimento Controller findAll >>>");

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<BancaRiferimento> listaBanche = new ArrayList<BancaRiferimento>();
			Query query = entityManager.createNativeQuery("SELECT * FROM banca_riferimento");
			listaBanche.addAll((List<BancaRiferimento>) query.getResultList());
			transaction.commit();
			return listaBanche;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Override
	public void delete(BancaRiferimento bancaRiferimento) {
		logger.info("sei nel BancaRiferimento Controller delete >>>" + bancaRiferimento);

		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(bancaRiferimento) ? bancaRiferimento
					: entityManager.merge(bancaRiferimento));
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
