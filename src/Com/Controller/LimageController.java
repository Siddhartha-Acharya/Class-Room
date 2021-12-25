package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.LimageDao;
import Com.Model.Limagepojo;
import Com.Model.TImagepojo;

/**
 * Servlet implementation class LimageController
 */
@WebServlet("/LimageController")
public class LimageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LimageDao dao=new LimageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimageController() {
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
        	Limagepojo bean=dao.getdetails2(id);
       	
             
       	 session.setAttribute("pojo3", bean);
             
       	 response.sendRedirect("Libraryprofile.jsp");            
        }
        catch (Exception ex)
        {
            throw new ServletException(ex);
        }
	}

}
