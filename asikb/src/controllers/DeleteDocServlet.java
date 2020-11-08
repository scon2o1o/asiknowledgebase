package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.DocumentDAO;

/**
 * Servlet implementation class DeleteDocServlet
 */
@WebServlet("/DeleteDocServlet")
public class DeleteDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocumentDAO.instance.deleteDoc(Integer.parseInt(request.getParameter("id")), request.getParameter("user"), request.getParameter("name"));
		request.getRequestDispatcher("index.jsp")
		.forward(request, response);
	}
}
