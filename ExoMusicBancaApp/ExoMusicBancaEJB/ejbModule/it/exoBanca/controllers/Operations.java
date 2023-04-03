package it.exoBanca.controllers;

import javax.persistence.EntityManager;

import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;
import it.exolab.utility.ContoCorrenteUtility;

public class Operations {

	private EntityManager entityManager;

	public Operations(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertContoCorrente(Utente utente) {

		ContoCorrente contoCorrente = ContoCorrenteUtility.getContoCorrente(utente.getAnagrafica());
		entityManager.persist(entityManager.contains(contoCorrente) ? contoCorrente : entityManager.merge(contoCorrente));

	}

	public void updateContoCorrente(Utente oldUser,Utente newUser) {
		String numeroConto = ContoCorrenteUtility.getNumeroConto(oldUser.getAnagrafica());
		ContoCorrente oldContoCorrente = new ContoCorrenteEJB().findByNumeroConto(numeroConto);
		entityManager.remove(oldContoCorrente);

		entityManager.persist(newUser);

		ContoCorrente newContoCorrente = ContoCorrenteUtility.getContoCorrente(newUser.getAnagrafica(), oldContoCorrente.getSaldo(), oldContoCorrente.getDataScadenza());
		entityManager.persist(newContoCorrente);

	}

	public void deleteContoCorrente(Utente utente) {

		ContoCorrente contoCorrente = ContoCorrenteUtility.getContoCorrente(utente.getAnagrafica());
		entityManager.remove(entityManager.contains(contoCorrente) ? contoCorrente : entityManager.merge(contoCorrente));
	}
}
