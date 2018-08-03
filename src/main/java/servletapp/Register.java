package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletapp.UserSignIn;
/**
 * Servlet implementation class Register
 */
@WebServlet(name = "Register",
urlPatterns = {"/Register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username is " + userName);
		System.out.println("Password is" + password);
		UserSignIn.addUser(userName, password);
	
		response.sendRedirect("loginpage.html");
	}

}
