package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Dao.LibraryDao;
import Com.Model.Librarypojo;
import Com.Model.Loginpojo;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LibraryDao dao=new LibraryDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String Username=request.getParameter("username");
		
		String Password=request.getParameter("password");
		String Name=request.getParameter("name");
		String Number=request.getParameter("number");
		String Email=request.getParameter("email");
		
	
		
		Librarypojo c=new Librarypojo();
		
		
		c.setUsername(Username);
		c.setName(Name);
		c.setPassword(Password);
		c.setNumber(Number);
		c.setEmail(Email);
		
		String teacher=dao.library(c);
		
		if(teacher.equals("SUCCESS")){
			response.sendRedirect("LibraryRegistration.jsp");
		}
	}

}
