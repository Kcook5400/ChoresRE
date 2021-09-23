package model;

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
@Table(name = "chores")
public class chores {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int ID;
	@Column(name="NAME")
	private String name;
	@Column(name="TIMETOCOMPLETE")
	private int timeToComplete;
	@Column(name="AGEREQUIREMENT")
	private int ageRequirement;
	@Column(name="ASSIGNED")
	private String assigned;
	/**
	 * 
	 */
	public chores() {
		super();
	}
	
	

	/**
	 * @param iD
	 * @param name
	 * @param timeToComplete
	 * @param ageRequirement
	 * @param assigned
	 */
	public chores(int iD, String name, int timeToComplete, int ageRequirement, String assigned) {
		super();
		ID = iD;
		this.name = name;
		this.timeToComplete = timeToComplete;
		this.ageRequirement = ageRequirement;
		this.assigned = assigned;
	}



	public chores(int ageRequirement, String assigned, String name, int timeToComplete) {
		super();
		this.name = name;
		this.timeToComplete = timeToComplete;
		this.ageRequirement = ageRequirement;
		this.assigned = assigned;
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
	public int getTimeToComplete() {
		return timeToComplete;
	}
	public void setTimeToComplete(int timeToComplete) {
		this.timeToComplete = timeToComplete;
	}
	public int getAgeRequirement() {
		return ageRequirement;
	}
	public void setAgeRequirement(int ageRequirement) {
		this.ageRequirement = ageRequirement;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	
	public chores(String name, String assigned, int timeToComplete, int ageRequirement) {
		super();
		this.name = name;
		this.assigned = assigned;
		this.timeToComplete = timeToComplete;
		this.ageRequirement = ageRequirement;
	}
	
	
	public String returnChoreDetails() {
		return this.name +": " + this.assigned + ": " + this.timeToComplete + ": " + this.ageRequirement;}

	@Override
	public String toString() {
		return "chores [ID=" + ID + ", name=" + name + ", timeToComplete=" + timeToComplete + ", ageRequirement="
				+ ageRequirement + ", assigned=" + assigned + "]";
	}
	

}
