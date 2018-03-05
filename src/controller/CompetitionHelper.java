package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Competition;

;

public class CompetitionHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandGoehring");
	
	public void insertCompetition(Competition addCompetition) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(addCompetition);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Competition> showCompetitionRoster() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Competition> allResults = em.createQuery("select cp from Competition cp", Competition.class);
		List<Competition> allEntries = allResults.getResultList();
		em.close();
		return allEntries;
	}
}
