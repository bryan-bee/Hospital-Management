package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vaccines;
import DbService.DbService;

@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewVaccine() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}else if((boolean)request.getSession().getAttribute("isAdmin")){
			request.getRequestDispatcher("/WEB-INF/NewVaccine.jsp").forward(request, response);
		}else {
			response.sendRedirect("FrontPage");
		}
	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("isAdmin") != null) {
			if (!(boolean)request.getSession().getAttribute("isAdmin")) {
				response.sendRedirect("FrontPage");
		}else {
			String name = request.getParameter("name");
			int dosesRequired = Integer.parseInt(request.getParameter("dosesRequired"));
			String daysBetween = request.getParameter("between");
			DbService db = new DbService();
			db.addVacine(name, dosesRequired, daysBetween);
			db.close();
			response.sendRedirect("ListVaccines");			
			}
		}
	}
}
