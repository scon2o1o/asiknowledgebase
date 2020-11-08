package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myApp.ViewUser;

/**
 * Servlet implementation class ViewUserServlet
 */
@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ViewUser user = new ViewUser(request.getParameter("username"), request.getParameter("firstnames"),
				request.getParameter("surname"), request.getParameter("canadd"), request.getParameter("canedit"),
				request.getParameter("isadmin"));
		HttpSession session = request.getSession();
		session.setAttribute("viewuser", user);
		request.getRequestDispatcher("viewuser.jsp").forward(request, response);
	}

}
