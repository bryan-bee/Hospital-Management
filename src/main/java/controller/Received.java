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
import DbService.DbService;

@WebServlet("/Received")
public class Received extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Received() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}else {
				DbService db = new DbService();
				int id = Integer.parseInt(request.getParameter("id"));
				List<Patients> patients = (List<Patients>) getServletContext().getAttribute("patients");
				Patients patient = null;
				for(Patients pat:patients) {
					if (pat.getId() == id) {
						patient = pat;
						break;
					}
				}
				db.Received(patient.getId());
				db.decrement(patient.getVaccineId(), patient.getGivenVaccine().getTotalDosesLeft());
				response.sendRedirect("PatientList");
				return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
