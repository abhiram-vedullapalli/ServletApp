package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletapp.Crud;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet(name = "Retrieve" ,
urlPatterns = "/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.getRequestDispatcher("login.html").forward(request, response);
			
		}
		else {

		PrintWriter out = response.getWriter();
		String playName = request.getParameter("name");
		String acName = Crud.anyCase(playName);
		String details = Crud.retrievePlayer(acName);
		
		out.println("<html><head></head><body align=\"center\">");
		out.println("<h1 align=\"center\"> Details of Player : </h1>");
		out.print(details);
		out.println("<br> <br> <a href=\"create.html\">Create Player</a><br>");
		out.println("<br> <br> <a href=\"retrieve.html\">Retrieve another Player</a><br>");
		out.println("<br> <br> <a href=\"delete.html\">Delete Player</a><br>");
		out.println("<br> <br> <a href=\"update.html\">Update Player</a><br>");
		out.println("<br> <br> <a href=\"listall.html\">List all Players</a><br>");

		out.println("</body></html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.getRequestDispatcher("login.html").forward(request, response);
			
		}
	}
}
