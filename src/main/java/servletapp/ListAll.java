package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletapp.Crud;
/**
 * Servlet implementation class ListAll
 */
@WebServlet(name = "ListAll",
urlPatterns = {"/ListAll"})
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		Crud.listAllPlayers(out);
	
		out.println("<br> <br> <a href=\"create.html\">Create Player</a><br>");
		out.println("<br> <br> <a href=\"retrieve.html\">Retrieve Player</a><br>");
		out.println("<br> <br> <a href=\"delete.html\">Delete Player</a><br>");
		out.println("<br> <br> <a href=\"update.html\">Update Player</a><br>");
		out.println("<br> <br> <a href=\"ListAll.java\">List all Players</a><br>");
		
		out.println("</body></html>");
	}

}
