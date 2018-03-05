package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Band;

public class BandHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BandGoehring");

	public void insertBand(Band toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Band> showAllBands() {
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<Band> allResults = em.createQuery("Select li from Band li where li.bandType = 'basic'", Band.class);
		// Selects the info
		List<Band> allBands = allResults.getResultList();
		// need to close the entity manager
		em.close();

		return allBands;

	}
	
	/* public List<Band> showAllBands() {
		EntityManager em = emfactory.createEntityManager();
		// creates the query but does not execute it.
		TypedQuery<Band> allResults = em.createQuery("Select list_item from Band list_item", Band.class);
		// Selects the info
		List<Band> allBands = allResults.getResultList();
		// need to close the entity manager
		em.close();

		return allBands;

	} */

	public void deleteBand(Band toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Creating they query but does not execute
		TypedQuery<Band> typedQuery = em.createQuery("Select b from Band b where b.bandId = :selectedId", Band.class);
		typedQuery.setParameter("selectedId", toDelete.getBandId());
		// Gets the 1st one in the table
		typedQuery.setMaxResults(1);

		Band result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		System.out.println("Record has been deleted");
		em.close();

	}

	public Band searchForBandById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Band foundItem = em.find(Band.class, idToEdit);
		em.close(); // close
		// return the results of the query
		return foundItem;
	}

	public void updateBand(Band toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close(); // close
	}
}
