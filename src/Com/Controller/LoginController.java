package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.LoginDao;
import Com.Model.Loginpojo;
import Com.Model.idTypeBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LoginDao dao=new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		Loginpojo pojo=new Loginpojo();
    	pojo.setUsername(u);
    	pojo.setPassword(p);
    	idTypeBean s=null;

    	HttpSession session=request.getSession();
       try
		{
    	    s= dao.studentlogin(pojo);

       		String id=s.getId();
       		String type=s.getType();
			if(type.equals("Student"))
			{
				session.setAttribute("user_id", id);
				 session.setAttribute("username",u);
				 response.sendRedirect("StudentHome.jsp");
				 
			}
			else if(type.equals("Teacher"))
			{
			     session.setAttribute("username",u);
			     session.setAttribute("user_id", id);
				response.sendRedirect("TeacherHome.jsp");			
			}
			
			else{
				session.setAttribute("username",u);
			     session.setAttribute("user_id", id);
				response.sendRedirect("LibraryHome.jsp");	
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
			
		}
	}

}
