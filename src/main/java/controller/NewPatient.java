package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patients;
import model.Vaccines;
import DbService.DbService;

@WebServlet("/NewPatient")
public class NewPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}
		request.getRequestDispatcher("WEB-INF/NewPatient.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}else {
			@SuppressWarnings("unchecked")
		List<Vaccines> vaccines = (List<Vaccines>) getServletContext().getAttribute("vaccines");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("vaccine"));
		Vaccines myVac=null;
		for (Vaccines v:vaccines) {
			if (id == v.getId()) {
				myVac = v;
				break;
			}
		}
		DbService db = new DbService();
		db.newPatient(name, id);
		int totalLeft = myVac.getTotalDosesLeft();
		db.decrement(id, totalLeft);
		db.close();
		response.sendRedirect("PatientList");
		
		}
		
	}
}
