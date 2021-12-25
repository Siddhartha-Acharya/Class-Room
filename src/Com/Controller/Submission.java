package Com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Dao.SubmissionDao;
import Com.Model.Submissionpojo;

/**
 * Servlet implementation class Submission
 */
@WebServlet("/Submission")
public class Submission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SubmissionDao dao=new SubmissionDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
HttpSession session=request.getSession();
		
		String teacher_id=request.getParameter("teacher_id");
				
				String student_id=(String) session.getAttribute("user_id");
				String aid=request.getParameter("id");
				String department=request.getParameter("department");
				String year=request.getParameter("year");
				String details=request.getParameter("details");
				String date=request.getParameter("submission_date");
				String identity=request.getParameter("identity");
			
				
			System.out.println("teacher="+teacher_id);
				
				Submissionpojo c=new Submissionpojo();
				
				c.setTeacher_id(teacher_id);
				c.setStudent_id(student_id);
				c.setId(aid);
				c.setDepartment(department);
				c.setYear(year);
				c.setDetails(details);
				c.setSubmission_date(date);
				c.setIdentity(identity);
			
				
				String teacher=dao.submit(c);
				
				if(teacher.equals("SUCCESS")){
					response.sendRedirect("stask.jsp");
				}
		
	}
		
	}


