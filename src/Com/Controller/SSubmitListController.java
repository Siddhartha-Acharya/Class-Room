package Com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.SubmitDao;
import Com.Model.Submitpojo;

/**
 * Servlet implementation class SSubmitListController
 */
@WebServlet("/SSubmitListController")
public class SSubmitListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SubmitDao dao=new SubmitDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSubmitListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession session =request.getSession();
		
//		String id=(String)session.getAttribute("user_id");
//		
//		System.out.println("sid="+id);
//		
		ArrayList<Submitpojo> s=dao.list();

	    session.setAttribute("submit", s);
	    
	    
	    response.sendRedirect("submitted.jsp");
	}

}
