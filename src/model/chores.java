package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 2, 2021
 */
@Entity
public class chores {
	@Id
	@GeneratedValue
	private int ID;
	private String name;
	private String assigned;
	private LocalDate dueDate;
	
	/**
	 * 
	 */
	public chores() {
		super();
	}
	

	public chores(int iD, String name, String assigned) {
		super();
		ID = iD;
		this.name = name;
		this.assigned = assigned;
	}
	public chores(String name, String assigned, LocalDate date) {
		super();
		this.name = name;
		this.assigned = assigned;
		this.dueDate=date;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}		
	
	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public String returnChoreDetails() {
		return this.name +": " + this.assigned;}


	@Override
	public String toString() {
		return "chores [ID=" + ID + ", name=" + name + ", assigned=" + assigned + ", dueDate=" + dueDate + "]";
	}



}
