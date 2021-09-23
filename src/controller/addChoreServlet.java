package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.chores;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addChoreServlet")
public class addChoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addChoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String chore = request.getParameter("chore");
		String assigned = request.getParameter("assigned");
		int timeToComplete = 1;
		int ageRequirement = 1;
		
		chores ch = new chores(chore, assigned, timeToComplete, ageRequirement);
		
		choresHelper dao = new choresHelper();
		
		dao.insertItem(ch);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
		
		
		
	}

}
