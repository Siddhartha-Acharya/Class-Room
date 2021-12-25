package Com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.TsubmitDao;
import Com.Model.Submitpojo;
import Com.Model.Tsubmitpojo;

/**
 * Servlet implementation class TsubmitController
 */
@WebServlet("/TsubmitController")
public class TsubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TsubmitDao dao=new TsubmitDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TsubmitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession session =request.getSession();
		
	//	String student_id=(String)session.getAttribute("user_id");
		
		String id=request.getParameter("id");
		
		
		System.out.println("aid="+id);
		
		ArrayList<Tsubmitpojo> s=dao.list(id);

	    session.setAttribute("tsubmit", s);
	    
	    
	    response.sendRedirect("teachersubmit.jsp");
	
		
	}

}
