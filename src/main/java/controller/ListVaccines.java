package controller;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbService.DbService;
import model.Vaccines;

@WebServlet("/ListVaccines")
public class ListVaccines extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListVaccines() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}else if((boolean)request.getSession().getAttribute("isAdmin")){
			DbService dbService = new DbService();
	        List<Vaccines> vaccines = dbService.getVaccines();
	        getServletContext().setAttribute( "vaccines", vaccines );
			request.getRequestDispatcher("/WEB-INF/ListVaccines.jsp").forward(request, response);
	        dbService.close();
		}else {
			response.sendRedirect("FrontPage");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
