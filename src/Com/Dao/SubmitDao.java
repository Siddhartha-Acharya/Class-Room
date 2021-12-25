package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.Submitpojo;

public class SubmitDao {
	
	public ArrayList<Submitpojo> list ()
	{
		ArrayList<Submitpojo> a=new ArrayList<Submitpojo>();
		
		ResultSet rs=null;
		String sql="select * from student_submission"; 
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
		//	stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				String assignment_details=rs.getString("identity");
				String department=rs.getString("department");
				String year=rs.getString("year");
				String submission_date=rs.getString("submission_date");
				String details=rs.getString("details");
				
				Submitpojo bean =new Submitpojo();
				
				
				bean.setIdentity(assignment_details);
				bean.setSubmission_date(submission_date);
				
				bean.setDepartment(department);
				bean.setYear(year);
				
				bean.setDetails(details);
				
			
				
				
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
