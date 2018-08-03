package servletapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletapp.UserSignIn;
import servletapp.Crud;
/**
 * Servlet implementation class LogOut
 */
@WebServlet(name="LogOut",
urlPatterns= {"/LogOut"})
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		request.getSession().invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("HomePage");
		rd.forward(request, response);
	}

}
