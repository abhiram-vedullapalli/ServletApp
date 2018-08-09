package servletapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
@WebServlet(name = "HomePage",
urlPatterns = {"/HomePage"})
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		out.println("<html><head><title>Register</title></head>");
		out.println("<body><div align=\"center\">");
		out.println("<h1>New User ? Register Here ... </h1>");
		out.println("<form action=\"Register\" method=\"post\">");
		out.println("Enter Name : <input type=\"text\" name=\"username\" required=\"required\" pattern=\"[a-z]{3,}\" title=\"Enter lower case letters & min of 3 characters\"> <br><br>\r\n" );
		out.println("Enter Password : <input type=\"password\" name=\"password\"  required=\"required\">");
		out.println("<br><br>\r\n" + "<input type=\"submit\" value=\"Register\">");
		out.println("<a href=\"loginpage.html\" style=\"color: Black;font-size: x-large; font-style: oblique; font: bolder;\" >Already Registered ? Sign In</a>");
        out.println("</form>\r\n" + "</div>\r\n" + "</body>\r\n" + " </html>");
	}

}
