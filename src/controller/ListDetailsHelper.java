package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 27, 2021
 */
public class ListDetailsHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("chores");

public void insertNewListDetails(ListDetails s) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(s);
	em.getTransaction().commit();
	em.close();
	
}

public List<ListDetails> getLists(){
	EntityManager em= emfactory.createEntityManager();
	List<ListDetails> allDetails = em.createQuery("Select d FROM ListDetails d").getResultList();
	return allDetails;
	
}

public void deleteList(ListDetails toDelete) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListDetails> typedQuery = em.createQuery("select detail from ListDetails detail where detail.id= :selectedId", ListDetails.class);
	typedQuery.setParameter("selectedId", toDelete.getId());
	typedQuery.setMaxResults(1);
	ListDetails result = typedQuery.getSingleResult();
	em.remove(result);
	em.getTransaction().commit();
	em.close();
	
}

public ListDetails searchForListDetailsById(Integer tempId) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	ListDetails found = em.find(ListDetails.class, tempId);
	em.close();
	return found;
	
}
public void updateList(ListDetails toEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
}
}
