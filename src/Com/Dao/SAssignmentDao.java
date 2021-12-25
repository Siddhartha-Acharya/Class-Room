package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.Assignmentpojo_1;
import Com.Model.CreateAssignmentModel;

public class SAssignmentDao {
	
	public ArrayList<Assignmentpojo_1> list (String id)
	{
		ArrayList<Assignmentpojo_1> a=new ArrayList<Assignmentpojo_1>();
		
		ResultSet rs=null;
		String sql="select t1.filename ,t1.first_date_submission ,t1.last_date_submission ,t2.faculty ,t2.name ,t1.id ,t1.teacher_id, t2.teacher_id ,s.year ,s.student_id from teacherassignment t1 inner join teacherdetails t2 on t1.teacher_id =t2.teacher_id inner join studentdetails s where s.student_id=?"; 
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		java.sql.Connection con=null;
		java.sql.PreparedStatement stmt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				String assignment_details=rs.getString("filename");
				String first_date_submission=rs.getString("first_date_submission");
				String last_date_submission=rs.getString("last_date_submission");
				String faculty=rs.getString("faculty");
				String name=rs.getString("name");
				String aid=rs.getString("id");
				String year=rs.getString("year");
				String Student_id=rs.getString("student_id");
				String teacher_id=rs.getString("teacher_id");
		
				
				
			
				
				Assignmentpojo_1 bean =new Assignmentpojo_1();
				
				
				bean.setFilename(assignment_details);
				bean.setFirst_date_submission(first_date_submission);
				bean.setLast_date_submission(last_date_submission);
				bean.setFaculty(faculty);
				bean.setName(name);
				bean.setId(aid);
				bean.setYear(year);
				bean.setStudent_id(Student_id);
				bean.setTeacher_id(teacher_id);
				
				a.add(bean);
	
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return a;
	}

}
