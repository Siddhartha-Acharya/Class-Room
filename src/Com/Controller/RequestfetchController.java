package Com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.RequestfetchDao;
import Com.Model.Requestfetchpojo;

/**
 * Servlet implementation class RequestfetchController
 */
@WebServlet("/RequestfetchController")
public class RequestfetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private RequestfetchDao dao=new RequestfetchDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestfetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		ArrayList<Requestfetchpojo> s=dao.list();
	    session.setAttribute("request", s);
	    
	    
	    response.sendRedirect("studentbooklist.jsp");
	}

}
