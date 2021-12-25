package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.Tsubmitpojo;

public class TsubmitDao {
	
	public ArrayList<Tsubmitpojo> list (String id)
	{
		ArrayList<Tsubmitpojo> a=new ArrayList<Tsubmitpojo>();
		
		ResultSet rs=null;
		String sql="select * from test.student_submission ss inner join test.studentdetails s where ss.id=?"; 
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
				String student_id=rs.getString("student_id");
				String name=rs.getString("name");
				String department=rs.getString("department");
				String year=rs.getString("year");
				String submission_date=rs.getString("submission_date");
				String details=rs.getString("details");
				String filepath=rs.getString("filepath");
				String assignment_id=rs.getString("id");
				
			
				
				Tsubmitpojo bean =new Tsubmitpojo();
				
				
				bean.setId(student_id);
				bean.setName(name);
				bean.setDepartment(department);
				bean.setYear(year);
				bean.setSubmission_date(submission_date);
				bean.setDetails(details);
				bean.setFilepath(filepath);
				bean.setId(assignment_id);
			
				
				
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
