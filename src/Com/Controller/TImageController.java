package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.TImageDao;
import Com.Model.TImagepojo;

/**
 * Servlet implementation class TImageController
 */
@WebServlet("/TImageController")
public class TImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TImageDao dao=new TImageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TImageController() {
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
        	TImagepojo bean=dao.getdetails(id);
       	
             
       	 session.setAttribute("pojo", bean);
             
       	 response.sendRedirect("TeacherProfile.jsp");            
        }
        catch (Exception ex)
        {
            throw new ServletException(ex);
        }
	}

}
