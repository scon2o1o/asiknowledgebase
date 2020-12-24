package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myApp.Document;
import myApp.DocumentDAO;

@WebServlet("/AddDocServlet")
public class AddDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddDocServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String details = request.getParameter("details");
		String url = request.getParameter("url");
		String category = request.getParameter("category");
		String subcategory = request.getParameter("subcategory");
		String author = request.getParameter("author");
		Document doc = new Document(name, details, url, category, author, subcategory);
		doc = DocumentDAO.instance.save(doc, request.getParameter("user"));
		if (doc != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}

}
