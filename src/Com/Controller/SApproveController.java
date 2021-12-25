package Com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.SApproveDao;
import Com.Model.SApprovepojo;

/**
 * Servlet implementation class SApproveController
 */
@WebServlet("/SApproveController")
public class SApproveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SApproveDao dao=new SApproveDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SApproveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession session = request.getSession();
		
		ArrayList<SApprovepojo> s = dao.list();
		
		session.setAttribute("ApprovedBook", s);

		response.sendRedirect("SApproveBook.jsp");

		
	}

}
