package controller;

import java.util.List;
import javax.persistence.*;
import model.chores;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 2, 2021
 */
public class choresHelper {
	static
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("chores");



public void insertItem(chores ch) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(ch);
	em.getTransaction().commit();
	em.close();
	
}
public List<chores> showAllItems(){
	EntityManager em = emfactory.createEntityManager();
	List<chores> allItems = em.createQuery("SELECT i FROM chores i").getResultList();
	return allItems;
}

public void deleteItem(chores toDelete) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<chores> typedQuery = em.createQuery("select ch from chores ch where ch.name = :selectedname and ch.assigned = :selectedassigned and ch.timeToComplete = :selectedtimeToComplete and ch.ageRequirement = :selectedageRequirement", chores.class);
	
	typedQuery.setParameter("selectedname", toDelete.getName());
	typedQuery.setParameter("selectedassigned", toDelete.getAssigned());
	typedQuery.setParameter("selectedtimeToComplete", toDelete.getTimeToComplete());
	typedQuery.setParameter("selectedageRequirement", toDelete.getAgeRequirement());
	
	typedQuery.setMaxResults(1);
	
	chores result = typedQuery.getSingleResult();
	
	em.remove(result);
	em.getTransaction().commit();
	em.close();
	
}
/**
 * @param idToEdit
 * @return
 */
public chores searchForItemById(int idToEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	chores found = em.find(chores.class, idToEdit);
	em.close();
	return found;
}
/**
 * @param toEdit
 */
public void updateItem(chores toEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
	
	
}
/**
 * @param storeName
 * @return
 */
public List<chores> searchForItemByStore(String choresName) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<chores> typedQuery = em.createQuery("select ch from chores ch where ch.name = :selectedStore", chores.class);
	typedQuery.setParameter("selectedStore", choresName);
	List<chores> foundItems = typedQuery.getResultList();
	em.close();
	return foundItems;
}
/**
 * @param itemName
 * @return
 */
public List<chores> searchForItemByItem(String itemName) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<chores> typedQuery = em.createQuery("select ch from chores ch where ch.name = :selectedname", chores.class);
	typedQuery.setParameter("selectedStore", itemName);
	List<chores> foundItems = typedQuery.getResultList();
	em.close();
	return foundItems;
}

public void cleanUp() {
	emfactory.close();

}

}