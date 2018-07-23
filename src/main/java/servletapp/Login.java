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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("User name in login page" + userName);
		System.out.println("Password in login page " + password);
		System.out.println("Password from Hashmap" + UserSignIn.credentials.get(userName));
		if (UserSignIn.credentials.containsKey(userName) && UserSignIn.credentials.get(userName).equals(password)) {

			HttpSession session = request.getSession();
			session.setAttribute(userName, userName);
			Cookie cookie = new Cookie(userName, userName);

			out.println("<html><head>");
			out.println(
					"<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" charset=\"ISO-8859-1\">");
			out.println("<link rel=\"stylesheet\" href=\"css/styling.css\">\r\n" + "");
			out.println("</head><body>");
			out.println("<div class=\"w3-container w3-black\">");
			out.println("<h1 class=\" w3-center w3-padding-large\">Servlet Programs</h1>\r\n"
					+ "		<div class=\"w3-bar\">\r\n"
					+ "			<a href=\"dummy.html\" class=\"w3-bar-item w3-button w3-mobile\">Add two numbers</a> \r\n"
					+ "			<a href=\"crud.html\" class=\"w3-bar-item w3-button w3-mobile\">CRUD on Servlet</a>\r\n"
					+ "		</div>\r\n" + "	</div>");
			out.println("</body></html>");
		}else {
			out.println("<html><head><title>Invalid User</title></head>");
			out.println("<body align=\"center\">");
			out.println("<h1>User does not Exist</h1>");
			out.println("<br> <br> <a href=\"login.html\">Log In</a><br>");
			out.println("<br> <br> <a href=\"register.html\">Register</a><br>");

		}
	} 
}
