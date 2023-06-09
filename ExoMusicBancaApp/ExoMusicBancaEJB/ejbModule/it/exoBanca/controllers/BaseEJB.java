package it.exoBanca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exolab.costanti.Const;

public abstract class BaseEJB<T> {

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Const.MODELS_PROJECT_NAME);
	private EntityManager entityManager;
	private EntityTransaction transaction;

	protected Operations operations = new Operations(entityManagerFactory.createEntityManager());

	public T insert(T model) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(entityManager.contains(model) ? model : entityManager.merge(model));
			transaction.commit();
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public T update (T model) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(model);
			transaction.commit();
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public void delete(T model) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}
	}

	public T findById(Class<T> modelClass, Integer id) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			T model = entityManager.find(modelClass, id);
			transaction.commit();
			return model;
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String table){
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<T> listaModel = new ArrayList<T>();
			Query query = entityManager.createNativeQuery("SELECT * FROM " + table);
			listaModel.addAll(query.getResultList());
			transaction.commit();
			return listaModel;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void createEntityManager() {
		entityManager = entityManagerFactory.createEntityManager();
	}
}
