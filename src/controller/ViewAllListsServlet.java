package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Assignee;
import model.ListDetails;
import model.chores;

/**
 * Servlet implementation class ViewAllListsServlet
 */
@WebServlet("/viewAllListsServlet")
public class ViewAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper alh = new ListDetailsHelper();
		List<ListDetails> abc = alh.getLists();
		request.setAttribute("allLists", abc); 
		
		//I added this to help with troubleshooting to see what was going in.
		for(ListDetails d: alh.getLists()){
			System.out.println(d.toString());
		}
		
		if(abc.isEmpty()) {
			request.setAttribute("allLists", " ");
		}
		getServletContext().getRequestDispatcher("/chores-by-user.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
