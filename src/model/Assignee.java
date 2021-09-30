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
	private String AssigneeName;
	
	
	/**
	 * 
	 */
	public Assignee() {
		super();
	}
	
	public Assignee(int id, String AssigneeName) {
		super();
		this.id=id;
		this.AssigneeName= AssigneeName;
		
	}
	public Assignee(String AssigneeName) {
		super();
		this.AssigneeName= AssigneeName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopperName() {
		return AssigneeName;
	}

	public void setShopperName(String AssigneeName) {
		this.AssigneeName = AssigneeName;
	}

	@Override
	public String toString() {
		return "Assignee [id=" + id + ", AssigneeName=" + AssigneeName + "]";
	}


	

}
