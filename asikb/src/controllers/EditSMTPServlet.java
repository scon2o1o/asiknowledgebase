package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.SMTPDAO;

/**
 * Servlet implementation class EditSMTPServlet
 */
@WebServlet("/EditSMTPServlet")
public class EditSMTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSMTPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SMTPDAO.instance.editSMTPSettings(request.getParameter("server"), Integer.parseInt(request.getParameter("port")), request.getParameter("auth"), request.getParameter("starttls"), request.getParameter("fromaddress"), request.getParameter("username"), request.getParameter("password"));
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
