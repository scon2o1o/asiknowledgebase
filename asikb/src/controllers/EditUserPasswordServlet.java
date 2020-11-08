package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.UserDAO;

@WebServlet("/EditUserPasswordServlet")
public class EditUserPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserPasswordServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO.instance.editUserPassword(request.getParameter("username"), request.getParameter("password"));
		request.getRequestDispatcher("viewuser.jsp").forward(request, response);
	}

}
