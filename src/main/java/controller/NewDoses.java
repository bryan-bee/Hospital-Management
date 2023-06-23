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

@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewDoses() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("loggedIn") == null) {
			response.sendRedirect("Login");
		}else if((boolean)request.getSession().getAttribute("isAdmin")){
			request.getRequestDispatcher("/WEB-INF/NewDoses.jsp").forward(request, response);
		}else {
			response.sendRedirect("FrontPage");
		}
	}
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("isAdmin") != null) {
			if (!(boolean)request.getSession().getAttribute("isAdmin")) {
				response.sendRedirect("FrontPage");
		}else {
			List<Vaccines> vaccine = (List<Vaccines>) getServletContext().getAttribute("vaccines");
			int received = Integer.parseInt(request.getParameter("received"));
			int id = Integer.parseInt(request.getParameter("name"));
			Vaccines myVac = null;
			for (Vaccines v : vaccine) {
				if (v.getId() == id) {
					myVac = v;
					break;
				}
			}
			int currStockforLeft = myVac.getTotalDosesLeft();
			int totalLeft = currStockforLeft + received;
			int currStockforTotalReceived = myVac.getTotalDosesLeft();
			currStockforTotalReceived += received;
	
			DbService db = new DbService();
			db.NewDose(id, totalLeft, currStockforTotalReceived);
			db.close();
			response.sendRedirect("ListVaccines");
		}
		}
	}

}
