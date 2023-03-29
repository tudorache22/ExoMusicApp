package it.exoBanca.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exoBanca.models.BancaRiferimento;

public class BancaRiferimentoCrud extends BaseCrud<BancaRiferimento> {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(entityProjectName);
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public BancaRiferimento insert(BancaRiferimento bancaRiferimento) {

		System.out.println("dentro il crud  -- insert -- " + bancaRiferimento);
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
			entityManager.close();
		}
		return null;
	}

	public BancaRiferimento update(BancaRiferimento bancaRiferimento) {

		System.out.println("dentro il crud  -- update -- " + bancaRiferimento);
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

	public BancaRiferimento findById(Integer idBancaRiferimento) {

		System.out.println("dentro il crud  -- findById -- " + idBancaRiferimento);
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

	public void delete(BancaRiferimento bancaRiferimento) {

		System.out.println("dentro il crud  -- delete -- " + bancaRiferimento);
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

	public List<BancaRiferimento> findAll() {

		System.out.println("dentro il crud  -- findAll -- ");
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

}
