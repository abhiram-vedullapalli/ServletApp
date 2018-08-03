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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.getRequestDispatcher("HomePage").forward(request, response);
			
		}
		else {
			
		
		PrintWriter out = response.getWriter();
		String playName = request.getParameter("name");
		String acName = Crud.anyCase(playName);
		String playTeam = request.getParameter("team");
		String acTeam = Crud.anyCase(playTeam);
		int playAge = Integer.parseInt(request.getParameter("age")); 
		Crud.createPlayer(acName,acTeam,playAge);
		out.println("<html><head></head><body align=\"center\">");
		out.println("<p> Player created </p>");
	
		out.println("<br> <br> <a href=\"createplayer.html\">Create another Player</a><br>");
		out.println("<br> <br> <a href=\"retrieveplayer.html\">Retrieve Player</a><br>");

		out.println("<br> <br> <a href=\"deleteplayer.html\">Delete Player</a><br>");
		out.println("<br> <br> <a href=\"updateplayer.html\">Update Player</a><br>");
		out.println("<br> <br> <a href=\"ListAll\">List all Players</a><br>");

		out.println("</body></html>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.getRequestDispatcher("HomePage").forward(request, response);
			
		}
	}

}
