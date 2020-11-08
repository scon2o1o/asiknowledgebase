package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.AuditDAO;
import myApp.User;
import myApp.UserDAO;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUserServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String firstnames = request.getParameter("Firstnames");
		String surname = request.getParameter("Surname");
		String canadd = request.getParameter("Canadd");
		String canedit = request.getParameter("Canedit");
		String isadmin = request.getParameter("Isadmin");
		User user = new User(username, password, firstnames, surname, canadd, canedit, isadmin);
		user = UserDAO.instance.save(user, request.getParameter("user"));
		if (user != null) {
			request.getRequestDispatcher("users.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("adduser.jsp").forward(request, response);
		}
	}

}
