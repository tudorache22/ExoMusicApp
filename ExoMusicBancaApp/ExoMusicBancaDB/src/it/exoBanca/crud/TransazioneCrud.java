package it.exoBanca.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exoBanca.models.Transazione;

public class TransazioneCrud extends BaseCrud<Transazione> {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(entityProjectName);
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Transazione insert(Transazione transazione) {

		System.out.println("dentro il crud  -- insert -- " + transazione);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(transazione)) {
				transazione = entityManager.merge(transazione);
			}
			entityManager.persist(transazione);
			transaction.commit();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Transazione update(Transazione transazione) {

		System.out.println("dentro il crud  -- update -- " + transazione);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(transazione);
			transaction.commit();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Transazione findById(Integer idTransazione) {

		System.out.println("dentro il crud  -- findById -- " + idTransazione);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Transazione transazione = new Transazione();
			transazione = entityManager.find(Transazione.class, idTransazione);
			transaction.commit();
			return transazione;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public void delete(Transazione transazione) {

		System.out.println("dentro il crud  -- delete -- " + transazione);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(transazione) ? transazione : entityManager.merge(transazione));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}

	public List<Transazione> findAll() {

		System.out.println("dentro il crud  -- findAll -- ");
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Transazione> listaTransazioni = new ArrayList<Transazione>();
			Query query = entityManager.createNativeQuery("SELECT * FROM utenti");
			listaTransazioni.addAll((List<Transazione>) query.getResultList());
			transaction.commit();
			return listaTransazioni;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

}
