package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.AuditDAO;
import myApp.CategoryDAO;
import myApp.SubcategoryDAO;

/**
 * Servlet implementation class AddSubcategoryServlet
 */
@WebServlet("/AddSubcategoryServlet")
public class AddSubcategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubcategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubcategoryDAO.instance.addSubcategory(request.getParameter("name"), request.getParameter("user"));
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
