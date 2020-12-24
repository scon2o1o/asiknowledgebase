package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myApp.SysadminDAO;

@WebServlet("/EditSysadminServlet")
public class EditSysadminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditSysadminServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SysadminDAO.instance.editSysadmin(request.getParameter("username"), request.getParameter("email"));
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
