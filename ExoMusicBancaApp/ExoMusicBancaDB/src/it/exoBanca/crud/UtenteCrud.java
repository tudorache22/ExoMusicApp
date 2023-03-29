package it.exoBanca.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exoBanca.models.Utente;

public class UtenteCrud extends BaseCrud<Utente> {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(entityProjectName);
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Utente insert(Utente utente) {

		System.out.println("dentro il crud  -- insert -- " + utente);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(utente)) {
				utente = entityManager.merge(utente);
			}
			entityManager.persist(utente);
			transaction.commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Utente update(Utente utente) {

		System.out.println("dentro il crud  -- update -- " + utente);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(utente);
			transaction.commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Utente findById(Integer idUtente) {

		System.out.println("dentro il crud  -- findById -- " + idUtente);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Utente utente = new Utente();
			utente = entityManager.find(Utente.class, idUtente);
			transaction.commit();
			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Utente findByEmailPassword(Utente utente) {
		Utente utenteTrovato;
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager
					.createQuery("Select p FROM Passeggero p WHERE p.email = :email And p.password = :password");
			query.setParameter("email", utente.getEmail());
			query.setParameter("password", utente.getPassword());
			utenteTrovato = (Utente) query.getSingleResult();
			System.out.println(utenteTrovato);
			entityManager.getTransaction().commit();
			return utenteTrovato;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public void delete(Utente utente) {

		System.out.println("dentro il crud  -- delete -- " + utente);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(utente) ? utente : entityManager.merge(utente));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}

	public List<Utente> findAll() {

		System.out.println("dentro il crud  -- findAll -- ");
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Utente> listaUtenti = new ArrayList<Utente>();
			Query query = entityManager.createNativeQuery("SELECT * FROM utente");
			listaUtenti.addAll((List<Utente>) query.getResultList());
			transaction.commit();
			return listaUtenti;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

}
