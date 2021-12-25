package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.CreateAssignmentDao;
import Com.Model.CreateAssignmentModel;

/**
 * Servlet implementation class CreateAssignment
 */
@WebServlet("/CreateAssignment")
public class CreateAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CreateAssignmentDao dao=new CreateAssignmentDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		HttpSession session=request.getSession();
//		String teacher_id=(String) session.getAttribute("user_id");
//		String Asignment_details=request.getParameter("assignment_details");
//		String firstdate=request.getParameter("first_date_submission");
//		String lastdate=request.getParameter("last_date_submission");
//		String department=request.getParameter("department");
//		String year=request.getParameter("year");
//		String id=request.getParameter("id");
//		
//		CreateAssignmentModel model=new CreateAssignmentModel();
//		model.setAssignment_details(Asignment_details);
//		model.setFirst_date_submission(firstdate);
//		model.setDepartment(department);
//		model.setLast_date_submission(lastdate);
//		model.setTeacher_id(teacher_id);
//		model.setYear(year);
//		model.setId(id);
//		
//	//	String s=dao.assignment(model);
//		//if(s.equals("SUCCESS")){
//			response.sendRedirect("assignmentupload.jsp");
//		}
//	}

}
}
