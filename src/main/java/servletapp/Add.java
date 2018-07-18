package servletapp;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
//@WebServlet( name = "Add",
//urlPatterns = {"/Add"}
//)
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		int f = Integer.parseInt(first);
		int s = Integer.parseInt(second);
		int add = f + s;
		String value = Integer.toString(add);
		response.setContentType("text/plain");
		out.println("Addition is " + add);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
