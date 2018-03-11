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
	

	public List<Competition> showAllCompetition() {
		EntityManager em = emfactory.createEntityManager();
		
	TypedQuery<Competition> allResults = em.createQuery("Select c from Competition c", Competition.class);
	
		List<Competition> allCompetition = allResults.getResultList();
//		System.out.println("From showAllCompetition method in Competition Helper");
//		for (Competition a: allCompetition) {
//			System.out.println(a.toString());
//		}
		em.close();
		return allCompetition;
	}
}


