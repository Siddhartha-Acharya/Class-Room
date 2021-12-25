package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.RequestBookDao;
import Com.Model.RequestBookpojo;

/**
 * Servlet implementation class RequestBookController
 */
@WebServlet("/RequestBookController")
public class RequestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestBookDao dao=new RequestBookDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession  session=request.getSession();
		
		
		String student_id=(String) session.getAttribute("user_id");
		String book_name=request.getParameter("book_name");
		String book_id=request.getParameter("book_id");
	
		
		RequestBookpojo pojo=new RequestBookpojo();
		
		pojo.setStudent_id(student_id);
		pojo.setBook_name(book_name);
		pojo.setBook_id(book_id);
		
		String s=dao.check(pojo);
		if(s.equals("success"))
		{
			response.sendRedirect("studentprofile.jsp");
		}
		else
		{
			response.sendRedirect("requestBook.jsp");
		}
	}

}
