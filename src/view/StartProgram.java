package view;

import java.util.List;
import java.util.Scanner;

import controller.choresHelper;
import model.chores;
/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 2, 2021
 */
public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static choresHelper lih = new choresHelper();
		

		private static void addAnItem() {
			System.out.print("Enter a name of a chore: ");
			String name = in.nextLine();
			System.out.print("Enter an who it is assigned to: ");
			String assigned = in.nextLine();
			System.out.print("Enter the time it takes to complete: ");
			int timeToComplete = in.nextInt();
			System.out.print("Enter the age required for this chore: ");
			int ageRequirement = in.nextInt();
			
			chores toAdd = new chores(name, assigned, timeToComplete, ageRequirement);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			System.out.print("Enter a name of a chore to delete: ");
			String name = in.nextLine();
			System.out.print("Enter an who it is assigned to: ");
			String assigned = in.nextLine();
			System.out.print("Enter the time it takes to complete: ");
			int timeToComplete = in.nextInt();
			System.out.print("Enter the age required for this chore: ");
			int ageRequirement = in.nextInt();
			chores toDelete = new chores(name, assigned);
			lih.deleteItem(toDelete);
			

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by chore name");
			System.out.println("2 : Search by assigned");
			int searchBy = in.nextInt();
			in.nextLine();
			List<chores> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the store name: ");
				String chorename = in.nextLine();
				foundItems = lih.searchForItemByStore(chorename);
				
				
			} else {
				System.out.print("Enter assigned to: ");
				String assigned = in.nextLine();
				foundItems = lih.searchForItemByItem(assigned);
				

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (chores l : foundItems) {
					System.out.println(l.getID() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				chores toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getAssigned());
				System.out.println("1 : Update chore name");
				System.out.println("2 : Update assigned to");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New chore name: ");
					String newchoreName = in.nextLine();
					toEdit.setName(newchoreName);
				} else if (update == 2) {
					System.out.print("New Assigned person: ");
					String newAssigned = in.nextLine();
					toEdit.setAssigned(newAssigned);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our family chore list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a chore");
				System.out.println("*  2 -- Edit a chore");
				System.out.println("*  3 -- Delete a chore");
				System.out.println("*  4 -- View the list of chores");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<chores> allchores = lih.showAllItems();
			
			for(chores singleChore: allchores) {
				System.out.println(singleChore.returnChoreDetails());
			}
			

		}

	}