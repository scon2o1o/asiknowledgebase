package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.SMTPDAO;

@WebServlet("/EditSMTPServlet")
public class EditSMTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditSMTPServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SMTPDAO.instance.editSMTPSettings(request.getParameter("server"),
				Integer.parseInt(request.getParameter("port")), request.getParameter("auth"),
				request.getParameter("starttls"), request.getParameter("fromaddress"), request.getParameter("username"),
				request.getParameter("password"));
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}
}
