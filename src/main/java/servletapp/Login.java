package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servletapp.UserSignIn;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		if (UserSignIn.credentials.containsKey(userName) && UserSignIn.credentials.get(userName).equals(password)) {

			HttpSession session = request.getSession();
			session.setAttribute(userName, userName);
			Cookie cookie = new Cookie(userName, userName);
			//request.getRequestDispatcher("crud.html").forward(request, response);
			response.sendRedirect("crudplayer.html");
		
		}else {
			out.println("<html><head><title>Invalid User</title></head>");
			out.println("<body align=\"center\">");
			out.println("<h1>Username or Password is incorrect . Please try again</h1>");
			out.println("<br> <br> <a href=\"loginpage.html\">Try Logging In again</a><br>");
			out.println("<br> <br> <a href=\"HomePage\">Still not Registered ??</a><br>");

		}
	} 
}
