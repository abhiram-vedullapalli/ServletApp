package servletapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletapp.Crud;
import servletapp.Details;/**
 * Servlet implementation class Update
 */
@WebServlet(name="Update",
urlPatterns= {"/Update"})
public class Update extends HttpServlet {
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
		
		Details info = Crud.players.get(acName);
		if(info == null) {
			out.println("<html><head></head><body align=\"center\">");
			out.println("<h1> " + acName + " was not Created at all or Deleted previously , Create another Player </h1>");
			out.println("<br> <br> <a href=\"create.html\">Create another Player</a><br>");
			out.println("<br> <a href=\"retrieve.html\">Retrieve Player</a><br>");

			out.println("<br> <a href=\"delete.html\">Delete Player</a><br>");
			out.println("<br> <a href=\"update.html\">Update Player</a><br>");
			out.println("<br> <a href=\"ListAll\">List all Players</a><br>");

		} else {
	
		
		out.println("<html><head></head><body align=\"center\">");
		out.println("<h1 align=\"center\">Update details of " + info.getName() + " : </h1>");
		out.println("<form align=\"center\" action=\"ChangeValues\" method=\"post\">");
		out.println("<br> <br> Existing details are present in text field , edit details you want to change");
		out.println("<br> <br> Name of Player : <input type=\"text\" name=\"name\" value="+info.getName()+" readonly=\"readonly\">");
		out.println("<br> <br> Edit Team name : <input type=\"text\" pattern=\"[A-Za-z]{2,}\" title=\"Enter alphabets\" required=\"required\" name=\"team\" value=" +info.getTeam()+">");
		out.println("<br> <br> Edit Age : <input type=\"number\" max=\"40\" min=\"16\" required=\"required\" name=\"age\" value="+info.getAge()+">");
		out.println("<br> <br> <input type=\"submit\" value=\"Update\">");
		out.println("</form>");
		
		
		out.println("</body></html>");
		}
	}
	}
}
