package Com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.ScheckDao;
import Com.Model.Scheckpojo;

/**
 * Servlet implementation class ScheckController
 */
@WebServlet("/ScheckController")
public class ScheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ScheckDao dao=new ScheckDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String id=(String) session.getAttribute("user_id");
		ArrayList<Scheckpojo> s=dao.list(id);
	    session.setAttribute("p", s);
	    
	    
	    response.sendRedirect("scheckbook.jsp");
	}

}
