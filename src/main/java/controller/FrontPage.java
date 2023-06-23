package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbService.DbService;
import model.User;


@WebServlet("/FrontPage")
public class FrontPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (request.getSession().getAttribute("loggedIn") == null || (boolean)request.getSession().getAttribute("loggedIn") == false) {
			response.sendRedirect("Login");
			return;
		}else {
			request.getRequestDispatcher("/WEB-INF/FrontPage.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
