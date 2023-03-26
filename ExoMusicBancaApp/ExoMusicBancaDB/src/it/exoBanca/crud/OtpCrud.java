package it.exoBanca.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.exoBanca.models.Otp;

public class OtpCrud extends BaseCrud<Otp> {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(entityProjectName);
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Otp insert(Otp otp) {

		System.out.println("dentro il crud  -- insert -- " + otp);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			if (!entityManager.contains(otp)) {
				otp = entityManager.merge(otp);
			}
			entityManager.persist(otp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Otp update(Otp otp) {

		System.out.println("dentro il crud  -- update -- " + otp);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.merge(otp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public Otp findById(Integer idOtp) {

		System.out.println("dentro il crud  -- findById -- " + idOtp);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Otp otp = new Otp();
			otp = entityManager.find(Otp.class, idOtp);
			transaction.commit();
			return otp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	public void delete(Otp otp) {

		System.out.println("dentro il crud  -- delete -- " + otp);
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.remove(entityManager.contains(otp) ? otp : entityManager.merge(otp));
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.flush();
			entityManager.close();
		}

	}

	public List<Otp> findAll() {

		System.out.println("dentro il crud  -- findAll -- ");
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			List<Otp> listaOtp = new ArrayList<Otp>();
			Query query = entityManager.createNativeQuery("SELECT * FROM utenti");
			listaOtp.addAll((List<Otp>) query.getResultList());
			transaction.commit();
			return listaOtp;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

}
