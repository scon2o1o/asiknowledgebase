package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.User;
import myApp.UserDAO;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(request.getParameter("username"), request.getParameter("firstnames"),
				request.getParameter("surname"), request.getParameter("canadd"), request.getParameter("canedit"),
				request.getParameter("isadmin"));
		UserDAO.instance.editUser(user);
		request.getRequestDispatcher("users.jsp").forward(request, response);
	}

}
