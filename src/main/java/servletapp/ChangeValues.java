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
 * Servlet implementation class ChangeValues
 */
@WebServlet("/ChangeValues")
public class ChangeValues extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("HomePage");

			
		}
		else {

		PrintWriter out = response.getWriter();
		String playerName = request.getParameter("name");
		String playerTeam = request.getParameter("team");
		int playerAge = Integer.parseInt(request.getParameter("age"));
		
		out.println("<html><head></head><body align=\"center\">");
		out.println("<h1>" + Crud.updatePlayer(playerName,playerTeam,playerAge)+ "</h1>");
		
		out.println("<br> <br> <a href=\"createplayer.html\">Create another Player</a><br>");
		out.println("<br> <a href=\"retrieveplayer.html\">Retrieve Player</a><br>");

		out.println("<br> <a href=\"deleteplayer.html\">Delete Player</a><br>");
		out.println("<br> <a href=\"updateplayer.html\">Update Player</a><br>");
		out.println("<br> <a href=\"ListAll\">List all Players</a><br>");

		out.println("</body></html>");

	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("HomePage");

			
		}
	}
}
