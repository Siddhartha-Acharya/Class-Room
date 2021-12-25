package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.SubmissionimageDao;
import Com.Model.Submissionimagepojo;
import Com.Model.TImagepojo;

/**
 * Servlet implementation class SubmissionimageController
 */
@WebServlet("/SubmissionimageController")
public class SubmissionimageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SubmissionimageDao dao=new SubmissionimageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmissionimageController() {
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
        	Submissionimagepojo bean=dao.getSubmit(id);
       	
             
       	 session.setAttribute("submitfile", bean);
             
       	 response.sendRedirect("submitted.jsp");            
        }
        catch (Exception ex)
        {
            throw new ServletException(ex);
        }

}
}