package model;

/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 29, 2021
 */
	import java.time.LocalDate;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
	@Entity
	/**
	 * @author kevin.cook - Kevin Cook
	 *CIS175 - Fall 2021 
	 * Sep 27, 2021
	 */
	public class ListDetails {
		@Id
		@GeneratedValue
		private int id;
		private String listName;
		private LocalDate dueDate;
		@OneToOne(cascade=CascadeType.PERSIST)
		private Assignee assignee;
		@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
		private List<chores> listOfitems;
		

		/**
		 * 
		 */
		public ListDetails() {
			// TODO Auto-generated constructor stub
			super();
		}
		
		public ListDetails(int id, String listName, LocalDate dueDate, Assignee assignee, List<chores> listOfItems) {
			super();
			this.id=id;
			this.listName=listName;
			this.dueDate=dueDate;
			this.assignee=assignee;
			this.listOfitems=listOfItems;
			
		}
		public ListDetails(String listName, Assignee  assignee, List<chores> listOfItems) {
			super();
			this.listName = listName;
			this.assignee=assignee;
			this.listOfitems=listOfItems;
			
		}
		public ListDetails(String listName, LocalDate dueDate,  Assignee  assignee) {
			super();
			this.listName = listName;
			this.dueDate=dueDate;
			this.assignee=assignee;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getListName() {
			return listName;
		}

		public void setListName(String listName) {
			this.listName = listName;
		}

		public LocalDate getdueDate() {
			return dueDate;
		}

		public void setdueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		public  Assignee  getAssignee() {
			return assignee;
		}

		public void setAssignee ( Assignee  assignee) {
			this.assignee = assignee;
		}

		public List<chores> getListOfitems() {
			return listOfitems;
		}

		public void setListOfitems(List<chores> listOfitems) {
			this.listOfitems = listOfitems;
		}

		@Override
		public String toString() {
			return "ListDetails [id=" + id + ", listName=" + listName + ", dueDate=" + dueDate + ", assignee=" + assignee
					+ ", listOfitems=" + listOfitems + "]";
		}
		
		
		

	}


