package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Assignee;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 27, 2021
 */
public class AssigneeHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("chores");
	
	public void insertShopper(Assignee s) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Assignee> showAllShoppers(){
		EntityManager em = emfactory.createEntityManager();
		List<Assignee> allAssignee = em.createQuery("Select s FROM Shopper s").getResultList();
		return allAssignee;
	}
	/**
	 * 
	 */
	public AssigneeHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public Assignee findShopper(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Assignee> typedQuery = em.createQuery("select sh from Shopper sh where sh.AssigneeName = :selectedName",Assignee.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Assignee foundAssignee;
		try {
			foundAssignee = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundAssignee = new Assignee(nameToLookUp);
		}
		em.close();

		return foundAssignee;
	}
	
	

}
