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
import java.text.SimpleDateFormat;
import java.util.Date;

import DbService.DbService;
import model.Patients;
import model.Vaccines;

@WebServlet("/PatientList")
public class PatientList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientList() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Vaccines getVac(int id) {
    	@SuppressWarnings("unchecked")
		List<Vaccines> vaccines = (List<Vaccines>) getServletContext().getAttribute("vaccines");
    	Vaccines vac = null;
		for(Vaccines v: vaccines) {
			if(v.getId() == id) { 
				vac = v;
				return v;
			}
		}
		return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}else {
			DbService db = new DbService();
			List<Vaccines> vaccines =  db.getVaccines();
	        getServletContext().setAttribute( "vaccines", vaccines );
	        List<Patients> patients = db.getPatients();
	        for (int i = 0; i < patients.size(); i++) {
	        	patients.get(i).setGivenVaccine(getVac(patients.get(i).getVaccineId()));
	        }
	        
	        getServletContext().setAttribute( "patients", patients );
			request.getRequestDispatcher("WEB-INF/PatientList.jsp").forward(request, response);
			db.close();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
