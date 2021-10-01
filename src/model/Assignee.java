package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignee")

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 27, 2021
 */
public class Assignee {
	@Id
	@GeneratedValue
	private int id;
	private String assigneeName;
	
	
	/**
	 * 
	 */
	public Assignee() {
		super();
	}
	
	public Assignee(int id, String assigneeName) {
		super();
		this.id=id;
		this.assigneeName= assigneeName;
		
	}
	public Assignee(String assigneeName) {
		super();
		this.assigneeName= assigneeName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	@Override
	public String toString() {
		return "Assignee [id=" + id + ", AssigneeName=" + assigneeName + "]";
	}


	

}
