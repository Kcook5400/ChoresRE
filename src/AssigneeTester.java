import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Assignee;
import model.ListDetails;
import model.chores;


/**
 * @author kevin.cook - Kevin Cook
 *CIS175 - Fall 2021 
 * Sep 27, 2021
 */
public class AssigneeTester {
	
	public static void main(String args[]) {

			Assignee dad = new Assignee("dad");
			ListDetailsHelper ldh = new ListDetailsHelper();
			
			chores dishes = new chores("dishes", "dad", LocalDate.now());
			chores laundry = new chores("laundry", "dad", LocalDate.now());
			
			List<chores> dadsChores = new ArrayList<chores>();
			dadsChores.add(dishes);
			dadsChores.add(laundry);
			
			
			
			
			ListDetails dadsList = new ListDetails("dads chores", dad, dadsChores);
			dadsList.setListOfitems(dadsChores);
			ldh.insertNewListDetails(dadsList);
			List<ListDetails> allLists = ldh.getLists();
					for(ListDetails a: allLists) {
						System.out.println(a.toString());
						
					}
				
			}
	}
