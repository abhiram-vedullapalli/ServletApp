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
 * Servlet implementation class Update
 */
@WebServlet(name="Update",
urlPatterns= {"/Update"})
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String playName = request.getParameter("name");
		String acName = Crud.anyCase(playName);
		String playTeam = request.getParameter("team");
		String acTeam = Crud.anyCase(playTeam);
		String playAge = request.getParameter("age");
		int age = Integer.parseInt(playAge);
		String upResult = null;
		if(!(request.getParameter("team").isEmpty() && request.getParameter("age").isEmpty())) {
			 upResult = Crud.updatePlayer(acName, acTeam, playAge);
		}
		if(request.getParameter("team").isEmpty() && !(request.getParameter("age").isEmpty())) {
		 upResult = Crud.updatePlayer(acName, age);
		}
		if(!(request.getParameter("team").isEmpty()) && request.getParameter("age").isEmpty()) {
			 upResult = Crud.updatePlayer(acName, acTeam);
		}
		
		out.println("<html><head></head><body>");
		out.println(upResult);
	
		out.println("<br> <br> <a href=\"create.html\">Create Player</a><br>");
		out.println("<br> <br> <a href=\"retrieve.html\">Retrieve Player</a><br>");
		out.println("<br> <br> <a href=\"delete.html\">Delete Player</a><br>");
		out.println("<br> <br> <a href=\"update.html\">Update Player</a><br>");
		out.println("<br> <br> <a href=\"listall.html\">List all Players</a><br>");
		
		out.println("</body></html>");
	}

}
