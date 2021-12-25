package Com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.TAssignmentDao;
import Com.Model.CreateAssignmentModel;

/**
 * Servlet implementation class TFetchController
 */
@WebServlet("/TFetchController")
public class TFetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TAssignmentDao dao=new TAssignmentDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TFetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session =request.getSession();
		
		String id=(String)session.getAttribute("user_id");
		
		//String id=request.getParameter("id");
		//session.setAttribute("assignment", aid);
		
		System.out.println("tid="+id);
		
		ArrayList<CreateAssignmentModel> s=dao.list(id);

	    session.setAttribute("teacher", s);
	    
	    
	    response.sendRedirect("assignmentlist.jsp");
		
	}

	}


