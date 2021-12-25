package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Dao.TeacherRegDao;
import Com.Model.Loginpojo;

/**
 * Servlet implementation class TeacherRegistrationController
 */
@WebServlet("/TeacherRegistrationController")
public class TeacherRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherRegDao dao=new TeacherRegDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegistrationController() {
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
		String Faculty=request.getParameter("faculty");
		String Email=request.getParameter("email");
		
	
		
		Loginpojo c=new Loginpojo();
		
		
		c.setUsername(Username);
		c.setName(Name);
		c.setPassword(Password);
		c.setFaculty(Faculty);
		c.setEmail(Email);
		
		String teacher=dao.registration(c);
		
		if(teacher.equals("SUCCESS")){
			response.sendRedirect("TeacherRegistration.jsp");
		}
	}

}


