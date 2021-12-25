package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.StudentRegDao;
import Com.Model.Loginpojo;

/**
 * Servlet implementation class StudentRegisterController
 */
@WebServlet("/StudentRegisterController")
public class StudentRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentRegDao dao= new StudentRegDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
       String Username=request.getParameter("username");
		
		String Password=request.getParameter("password");
		String Name=request.getParameter("name");
		String Department=request.getParameter("department");
		String Email=request.getParameter("semail");
		String Year=request.getParameter("year");
		String Registration_no=request.getParameter("registration_no");
		
	
		
		Loginpojo c=new Loginpojo();
		
		
		c.setUsername(Username);
		c.setName(Name);
		c.setPassword(Password);
		c.setDepartment(Department);
		c.setEmail(Email);
		c.setYear(Year);
		c.setRegistration_no(Registration_no);
		
	
		String teacher=dao.registration(c);
		
		if(teacher.equals("SUCCESS")){
			
			response.sendRedirect("StudentRegistration.jsp");
		}
	}

}
