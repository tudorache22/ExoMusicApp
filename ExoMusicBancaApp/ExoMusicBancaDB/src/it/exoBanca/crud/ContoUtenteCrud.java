package it.exoBanca.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exoBanca.models.ContoUtente;

public class ContoUtenteCrud extends BaseCrud<ContoUtente> {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(entityProjectName);
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public ContoUtente insert(ContoUtente contoUtente) {

		System.out.println("dentro il crud  -- insert -- " + contoUtente);
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
			entityManager.close();
		}
		return null;
	}

	public ContoUtente update(ContoUtente contoUtente) {

		System.out.println("dentro il crud  -- update -- " + contoUtente);
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

	public ContoUtente findById(Integer idContoUtente) {

		System.out.println("dentro il crud  -- findById -- " + idContoUtente);
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

	public void delete(ContoUtente contoUtente) {

		System.out.println("dentro il crud  -- delete -- " + contoUtente);
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

	public List<ContoUtente> findAll() {

		System.out.println("dentro il crud  -- findAll -- ");
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<ContoUtente> listaContoUtente = new ArrayList<ContoUtente>();
			Query query = entityManager.createNativeQuery("SELECT * FROM conto_utente");
			listaContoUtente.addAll((List<ContoUtente>) query.getResultList());
			transaction.commit();
			return listaContoUtente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

}
