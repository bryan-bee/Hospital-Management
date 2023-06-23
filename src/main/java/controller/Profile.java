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

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("null")
	private User findUser(int id) {
		DbService db = new DbService();
		User u = null;
		List<User> users = db.getUsers();
		for (User user: users) {
			if (user.getId() == id) {
				u=user;
				break;
			}
		}
		return u;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		User user = findUser(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/EditProfile.jsp").forward(request, response);

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService db = new DbService();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		System.out.println(id + " " + name + " " + password);
		db.editUser(id, name, password);
		List<User> users = db.getUsers();
		User user = null;
		for (User u: users) {
			if(u.getId() == (id)) {
				user = u;
				break;
			}
		}
		user.setName(name);
		request.getSession().setAttribute("user", user);
		db.close();
		response.sendRedirect("FrontPage");
		
	}

}
