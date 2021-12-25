package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.SimageDao;
import Com.Model.Simagepojo;
import Com.Model.TImagepojo;

/**
 * Servlet implementation class SimageController
 */
@WebServlet("/SimageController")
public class SimageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SimageDao dao=new SimageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
        String id=(String)session.getAttribute("user_id");
        System.out.println(id);

        try
        {
        	Simagepojo bean=dao.getdetails1(id);
       	
             
       	 session.setAttribute("pojo1", bean);
             
       	 response.sendRedirect("studentprofile.jsp");            
        }
        catch (Exception ex)
        {
            throw new ServletException(ex);
        }
	}

}
