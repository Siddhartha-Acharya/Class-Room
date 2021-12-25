package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.TassignmentUploadDao;
import Com.Model.Tassignmentuploadmodel;

/**
 * Servlet implementation class TassignmentUploadController
 */
@WebServlet("/TassignmentUploadController")
public class TassignmentUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private  TassignmentUploadDao dao=new TassignmentUploadDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TassignmentUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
        String id=(String)session.getAttribute("user_id");
        System.out.println(id);

        try
        {
        	Tassignmentuploadmodel bean=dao.getdetails(id);
       	 System.out.println(bean.getFilename());
             
       	 session.setAttribute("tassignment", bean);
             
       	 response.sendRedirect("TeacherProfile.jsp");            
        }
        catch (Exception ex)
        {
            throw new ServletException(ex);
        }
	}
	}


