package servletapp;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Create
 */
@WebServlet( name = "Create",
urlPatterns = {"/Create"}
)
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.getRequestDispatcher("login.html").forward(request, response);;
			
		}
		else {
			
		
		PrintWriter out = response.getWriter();
		String playName = request.getParameter("name");
		String acName = Crud.anyCase(playName);
		String playTeam = request.getParameter("team");
		String acTeam = Crud.anyCase(playTeam);
		String playAge = request.getParameter("age");
		Crud.createPlayer(acName,acTeam,playAge);
		out.println("<html><head></head><body align=\"center\">");
		out.println("<p> Player created </p>");
	
		out.println("<br> <br> <a href=\"create.html\">Create another Player</a><br>");
		out.println("<br> <br> <a href=\"retrieve.html\">Retrieve Player</a><br>");

		out.println("<br> <br> <a href=\"delete.html\">Delete Player</a><br>");
		out.println("<br> <br> <a href=\"update.html\">Update Player</a><br>");
		out.println("<br> <br> <a href=\"listall.html\">List all Players</a><br>");

		out.println("</body></html>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	}
}
