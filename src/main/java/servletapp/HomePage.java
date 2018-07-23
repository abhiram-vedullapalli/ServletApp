package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
//@WebServlet("/HomePage.html")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

		//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session == null) {
			//out.println("Session is null");
			//session = request.getSession();
			response.sendRedirect("login.html");
			//request.getRequestDispatcher("login.html").forward(request, response);
		}else {
			//out.println("Preexisting session");
			response.sendRedirect("crud.html");
			//request.getRequestDispatcher("crud.html").forward(request, response);
		}
	}

}
