package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myApp.SubcategoryDAO;

@WebServlet("/DeleteSubcategoryServlet")
public class DeleteSubcategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteSubcategoryServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubcategoryDAO.instance.deleteSubcategory(request.getParameter("subcategory"));
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
