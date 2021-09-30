package controller;

import java.io.IOException;
import java.time.LocalDate;

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
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
			}
		catch (NumberFormatException ex) {
			ld = LocalDate.now();
			}
		
		chores ch = new chores(chore, assigned, ld);
		
		choresHelper dao = new choresHelper();
		
		dao.insertItem(ch);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
		
		
		
	}

}
