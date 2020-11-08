package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myApp.Document;

/**
 * Servlet implementation class ViewDocumentServlet
 */
@WebServlet("/ViewDocumentServlet")
public class ViewDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewDocumentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document doc = new Document(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("details"), request.getParameter("url"), request.getParameter("category"), "", "", 0, "", request.getParameter("subcategory"));
		HttpSession session = request.getSession();
		session.setAttribute("document", doc);
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
