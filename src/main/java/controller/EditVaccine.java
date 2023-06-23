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

@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditVaccine() {
		super();
	}

	@SuppressWarnings("unchecked")
	private Vaccines findVaccine(int id) {
		List<Vaccines> vaccine = (List<Vaccines>) getServletContext().getAttribute("vaccines");
		Vaccines vac = null;
		for (Vaccines v:vaccine) {
			if (v.getId() == id) {
				vac = v;
				break;
			}
		}
		return vac;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}
		else if((boolean)request.getSession().getAttribute("isAdmin")){
			Vaccines myVaccine = findVaccine(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("vaccine", myVaccine.getName());
			request.getRequestDispatcher("/WEB-INF/EditVaccine.jsp").forward(request, response);
		}
		else{
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
			int dosage = Integer.parseInt(request.getParameter("dosage"));
			String between = request.getParameter("between");
			int id= Integer.parseInt(request.getParameter("id"));
	
			DbService db = new DbService();
			db.editVaccine(id, name, dosage, between);
	    	db.close();
			response.sendRedirect("ListVaccines");
		}
		
		}
	}

}
