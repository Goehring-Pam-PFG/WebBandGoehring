package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.MarchingBand;

public class MarchingBandHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandGoehring");

	public void insertBand(MarchingBand addMarchingBand) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(addMarchingBand);
		em.getTransaction().commit();
		em.close();
	}
	
	 
	 public void deleteMarchingBand(MarchingBand toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MarchingBand> typedQuery = em.createQuery("select mb from MarchingBand mb where mb.bandId = :selectedId",
				MarchingBand.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());
		typedQuery.setMaxResults(1);
		MarchingBand result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<MarchingBand> showAllMarchingBands() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<MarchingBand> allResults = em.createQuery("select mb from MarchingBand mb where mb.bandType = 'marching'", MarchingBand.class);
		List<MarchingBand> allMarchingBands = allResults.getResultList();
		em.close();
		return allMarchingBands;
	}
	
	public MarchingBand searchForMarchingBandById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MarchingBand foundMarchingBand = em.find(MarchingBand.class, idToEdit);
		em.close();
		return foundMarchingBand;
	}

	public void updateMarchingBand(MarchingBand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}
	

}
