package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbService.DbService;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (getServletContext().getAttribute("loggedIn") != null) {
			response.sendRedirect("FrontPage");
		}else {
			DbService db = new DbService();
			List<User> users = db.getUsers();
	        getServletContext().setAttribute( "users", users );
			HashMap<String, String> logins = new HashMap<String, String>();
			for (int i=0; i<users.size(); i++) {
				logins.put(users.get(i).getUsername(), users.get(i).getPassword());
			}
	        getServletContext().setAttribute( "logins", logins );
	        request.getRequestDispatcher("WEB-INF/Logins.jsp").forward(request, response);
			db.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService db = new DbService();
		List<User> users = db.getUsers();
		String name = request.getParameter("username");
		HashMap<String, String> logins = null;
		if(getServletContext().getAttribute("logins")!= null) {
			logins = (HashMap<String, String>) getServletContext().getAttribute("logins");
		}
		if(request.getParameter("password").equals(logins.get(name))){
			request.getSession().setAttribute("loggedIn", true);
			User user = null;
			for (User u: users) {
				if(u.getUsername().equals(name)) {
					user = u;
					break;
				}
			}
			request.getSession().setAttribute("isAdmin",user.isAdmin());
			request.getSession().setAttribute("user",user);
			response.sendRedirect("FrontPage");
		}else {
			response.sendRedirect("Login");

		}
		
	}

}
