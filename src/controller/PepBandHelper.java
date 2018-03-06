package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PepBand;

public class PepBandHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandGoehring");

	public void insertBand(PepBand addPepBand) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(addPepBand);
		em.getTransaction().commit();
		em.close();
		
	}

	public void deletePepBand(PepBand toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PepBand> typedQuery = em.createQuery("select pb from PepBand pb where pb.bandId = :selectedId",
				PepBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());
		typedQuery.setMaxResults(1);
		PepBand result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PepBand> showAllPepBands() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<PepBand> allResults = em.createQuery("select pb from PepBand pb where pb.bandType = 'pep'", PepBand.class);
		List<PepBand> allPepBands = allResults.getResultList();
		em.close();
		return allPepBands;
	}
	
	public PepBand searchForPepBandById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PepBand foundPepBand = em.find(PepBand.class, idToEdit);
		em.close();
		return foundPepBand;
	}

	public void updatePepBand(PepBand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}
}
