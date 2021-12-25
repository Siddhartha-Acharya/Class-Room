package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Dao.ProcessDao;
import Com.Model.Processpojo;

/**
 * Servlet implementation class ProcessController
 */
@WebServlet("/ProcessController")
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProcessDao dao=new ProcessDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String last_date_of_submission=request.getParameter("last_date_of_submission");
		String status=request.getParameter("status");
		String message=request.getParameter("message");
		String tranjection_id=request.getParameter("tranjection_id");
	
	
		Processpojo pojo=new Processpojo();
		pojo.setLast_date_of_submission(last_date_of_submission);
		pojo.setStatus(status);
		pojo.setMessage(message);
		pojo.setTranjection_id(tranjection_id);
		
		String s=dao.insert(pojo);
		if(s.equals("SUCCESS"))
		{
			response.sendRedirect("Libraryprofile.jsp");
		}
		else
		{
			response.sendRedirect("studentbooklist.jsp");
		}
	}

}
